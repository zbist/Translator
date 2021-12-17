package com.zbistapp.translator.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zbistapp.translator.data.entities.MainEntity
import com.zbistapp.translator.domain.local.ILocalRepo
import com.zbistapp.translator.domain.network.INetworkRepo
import com.zbistapp.translator.room.HistoryRoomEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MainViewModel(
    private val networkRepo: INetworkRepo,
    private val localRepo: ILocalRepo
) : ViewModel() {

    private val _isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val isLoadingLiveData: LiveData<Boolean> = _isLoadingLiveData
    private val _errorLiveData: MutableLiveData<Throwable> = MutableLiveData()
    val errorLiveData: LiveData<Throwable> = _errorLiveData
    private val _translationLiveData: MutableLiveData<List<MainEntity>> = MutableLiveData()
    val translationLiveData: LiveData<List<MainEntity>> = _translationLiveData


    fun onSearchClicked(text: String) {
        if (text.isNotBlank()) {
            _isLoadingLiveData.value = true
            viewModelScope.launch {
                networkRepo.fetchWords(text)
                    .flowOn(Dispatchers.IO)
                    .catch { _errorLiveData.value = it }
                    .collect {
                        _translationLiveData.value = it
                    }
                localRepo.addToHistory(HistoryRoomEntity(text))
                _isLoadingLiveData.postValue(false)
            }
        }
    }
}