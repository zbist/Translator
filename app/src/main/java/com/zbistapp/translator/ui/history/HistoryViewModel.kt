package com.zbistapp.translator.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zbistapp.translator.domain.local.ILocalRepo
import com.zbistapp.translator.room.HistoryRoomEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val localRepo: ILocalRepo
) : ViewModel() {

    private val _historyLiveData: MutableLiveData<List<HistoryRoomEntity>> = MutableLiveData()
    val historyLiveData: LiveData<List<HistoryRoomEntity>> = _historyLiveData
    private val _errorLiveData: MutableLiveData<Throwable> = MutableLiveData()
    val errorLiveData: LiveData<Throwable> = _errorLiveData

    fun fetchHistory() {
        viewModelScope.launch {
            localRepo.fetchHistory()
                .flowOn(Dispatchers.IO)
                .catch { _errorLiveData.value = it }
                .collect {
                    _historyLiveData.value = it
                }
        }
    }

    fun deleteHistory() {
        viewModelScope.launch {
            localRepo.deleteHistory()
            _historyLiveData.value = emptyList()
        }
    }
}