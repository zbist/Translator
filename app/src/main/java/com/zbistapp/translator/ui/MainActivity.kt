package com.zbistapp.translator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zbistapp.translator.R
import com.zbistapp.translator.navigation.MainRouter
import com.zbistapp.translator.navigation.RouterHolder
import com.zbistapp.translator.ui.main.MainFragment

class MainActivity : AppCompatActivity(R.layout.activity_main), RouterHolder {

    override val mainRouter = MainRouter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            mainRouter.openMain()
        }
    }
}