package com.github.ferum_bot.bookreuse.di.components

import com.github.ferum_bot.bookreuse.di.modules.CreatingNewStuffActivityViewModelsModule
import com.github.ferum_bot.bookreuse.di.scopes.ViewModelsScope
import com.github.ferum_bot.bookreuse.ui.activity.CreatingNewStuffActivity
import com.github.ferum_bot.bookreuse.viewmodels.factory.ViewModelFactory
import dagger.Subcomponent

/**
 * Created by Matvey Popov.
 * Date: 27.02.2021
 * Time: 23:09
 * Project: BookReuse
 */
@ViewModelsScope
@Subcomponent(modules = [
    CreatingNewStuffActivityViewModelsModule::class
])
interface CreatingNewStuffActivityComponent {

    fun inject(activity: CreatingNewStuffActivity)

    fun viewModelFactory(): ViewModelFactory

    @Subcomponent.Builder
    interface Builder {

        fun build(): CreatingNewStuffActivityComponent
    }
}