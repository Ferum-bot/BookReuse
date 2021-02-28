package com.github.ferum_bot.bookreuse.di.components

import com.github.ferum_bot.bookreuse.di.modules.MainActivitySubcomponents
import com.github.ferum_bot.bookreuse.di.modules.MainActivityViewModelsModule
import com.github.ferum_bot.bookreuse.di.scopes.ViewModelsScope
import com.github.ferum_bot.bookreuse.ui.activity.MainActivity
import com.github.ferum_bot.bookreuse.viewmodels.factory.ViewModelFactory
import dagger.Component
import dagger.Subcomponent

/**
 * Created by Matvey Popov.
 * Date: 27.02.2021
 * Time: 23:05
 * Project: BookReuse
 */
@ViewModelsScope
@Subcomponent(modules = [
    MainActivityViewModelsModule::class,
    MainActivitySubcomponents::class
])
interface MainActivityComponent {

    fun inject(activity: MainActivity)

    fun viewModelFactory(): ViewModelFactory

    fun authorizationComponent(): AuthorizationComponent.Builder

    @Subcomponent.Builder
    interface Builder {

        fun build(): MainActivityComponent
    }
}