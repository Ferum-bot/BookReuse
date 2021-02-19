package com.github.ferum_bot.bookreuse.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.ui.interfaces.SplashScreen

class LaunchActivity : AppCompatActivity(), SplashScreen {

    override fun onCreate(savedInstanceState: Bundle?) {
        removeSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
    }

    private fun removeSplashScreen() {
        setTheme(R.style.Theme_BookReuse)
    }

    override fun splashScreenHasShown() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}