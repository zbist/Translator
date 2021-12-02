package com.zbistapp.translator.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zbistapp.translator.domain.entities.MainEntity
import com.zbistapp.translator.domain.network.INetworkRepo
import kotlinx.coroutines.Dispatchers
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
            viewModelScope.launch(Dispatchers.IO) {
                _translationLiveData.postValue(networkRepo.fetchWords(text))
                _isLoadingLiveData.postValue(false)
            }
        }
    }
}