package com.zbistapp.translator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zbistapp.translator.R
import com.zbistapp.translator.ui.main.MainFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, MainFragment.newInstance())
                .commit()
        }
    }
}