package com.zbistapp.translator.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zbistapp.translator.domain.network.INetworkRepo
import com.zbistapp.translator.ui.main.MainViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(
    private val networkRepo: INetworkRepo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MainViewModel(networkRepo) as T
}