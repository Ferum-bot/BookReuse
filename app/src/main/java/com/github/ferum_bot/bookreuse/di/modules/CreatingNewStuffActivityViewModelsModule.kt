package com.github.ferum_bot.bookreuse.di.modules

import androidx.lifecycle.ViewModel
import com.github.ferum_bot.bookreuse.di.annotations.ViewModelKey
import com.github.ferum_bot.bookreuse.viewmodels.create_new_stuff.CreateNewStuffViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Matvey Popov.
 * Date: 27.02.2021
 * Time: 23:38
 * Project: BookReuse
 */
@Module
abstract class CreatingNewStuffActivityViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(CreateNewStuffViewModel::class)
    abstract fun bindCreateNewStuffViewModel(viewModel: CreateNewStuffViewModel): ViewModel
}