package com.zbistapp.translator.navigation

import androidx.appcompat.app.AppCompatActivity
import com.zbistapp.translator.R
import com.zbistapp.translator.ui.history.HistoryFragment
import com.zbistapp.translator.ui.main.MainFragment

class MainRouter(private val activity: AppCompatActivity) {

    fun openMain() {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, MainFragment.newInstance())
            .commit()
    }

    fun openHistory() {
        activity.supportFragmentManager.beginTransaction()
            .addToBackStack("")
            .replace(R.id.main_container, HistoryFragment.newInstance())
            .commit()
    }
}