package com.github.ferum_bot.bookreuse.di.components

import android.content.Context
import com.github.ferum_bot.bookreuse.di.modules.AppSubcomponents
import com.github.ferum_bot.bookreuse.di.modules.ResourcesModule
import com.github.ferum_bot.bookreuse.viewmodels.factory.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Matvey Popov.
 * Date: 27.02.2021
 * Time: 23:04
 * Project: BookReuse
 */
@Component(modules = [
    AppSubcomponents::class,
    ResourcesModule::class
])
interface AppComponent {

    fun creatingNewStuffActivityComponent(): CreatingNewStuffActivityComponent.Builder
    fun launchActivityComponent(): LaunchActivityComponent.Builder
    fun mainActivityComponent(): MainActivityComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun addContext(context: Context): Builder

        fun build(): AppComponent
    }
}