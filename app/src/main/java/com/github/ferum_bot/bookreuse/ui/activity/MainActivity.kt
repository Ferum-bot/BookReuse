package com.github.ferum_bot.bookreuse.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.ferum_bot.bookreuse.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        removeSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun removeSplashScreen() {
        setTheme(R.style.Theme_BookReuse)
    }
}