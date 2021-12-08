package com.zbistapp.translator.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zbistapp.translator.domain.entities.MainEntity
import com.zbistapp.translator.domain.network.INetworkRepo
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    private val networkRepo: INetworkRepo
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
                    .collect {
                        _translationLiveData.value = it
                    }
                _isLoadingLiveData.postValue(false)
            }
        }
    }
}