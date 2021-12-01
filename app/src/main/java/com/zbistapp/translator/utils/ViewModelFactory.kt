package com.zbistapp.translator.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zbistapp.translator.domain.network.INetworkRepo
import com.zbistapp.translator.ui.main.MainViewModel
import java.lang.IllegalStateException

class ViewModelFactory(
    private val networkRepo: INetworkRepo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {

            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(networkRepo) as T
            }

            else -> {
                throw IllegalStateException()
            }
        }
}