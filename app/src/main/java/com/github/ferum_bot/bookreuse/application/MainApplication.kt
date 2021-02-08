package com.github.ferum_bot.bookreuse.application

import android.app.Application

/**
 * Created by Matvey Popov.
 * Date: 08.02.2021
 * Time: 14:00
 * Project: BookReuse
 */
class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        setUpTimber()
    }

    private fun setUpTimber() {

    }
}