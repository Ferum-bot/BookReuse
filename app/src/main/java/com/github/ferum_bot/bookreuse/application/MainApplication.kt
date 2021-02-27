package com.github.ferum_bot.bookreuse.application

import android.app.Application
import com.github.ferum_bot.bookreuse.di.components.DaggerAppComponent
import timber.log.Timber

/**
 * Created by Matvey Popov.
 * Date: 08.02.2021
 * Time: 14:00
 * Project: BookReuse
 */
class MainApplication: Application() {

    val component by lazy {
        DaggerAppComponent.builder()
            .addContext(applicationContext)
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        setUpTimber()
    }

    private fun setUpTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initComponent() {

    }
}