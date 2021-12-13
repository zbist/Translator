package com.zbistapp.translator.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zbistapp.translator.domain.entities.MainEntity
import com.zbistapp.translator.domain.network.INetworkRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class MainViewModel(
    private val networkRepo: INetworkRepo
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val isLoadingLiveData: LiveData<Boolean> = _isLoadingLiveData
    private val _errorLiveData: MutableLiveData<Throwable> = MutableLiveData()
    val errorLiveData: LiveData<Throwable> = _errorLiveData
    private val _translationLiveData: MutableLiveData<List<MainEntity>> = MutableLiveData()
    val translationLiveData: LiveData<List<MainEntity>> = _translationLiveData


    fun onSearchClicked(text: String) {
        if (text.isNotBlank()) {
            _isLoadingLiveData.value = true
            compositeDisposable +=
                networkRepo.fetchWords(text)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        _translationLiveData.value = it
                        _isLoadingLiveData.value = false
                    }, {
                        _errorLiveData.value = it
                        _isLoadingLiveData.value = false
                    })
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}