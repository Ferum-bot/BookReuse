package com.github.ferum_bot.bookreuse.di.modules

import androidx.lifecycle.ViewModel
import com.github.ferum_bot.bookreuse.di.annotations.ViewModelKey
import com.github.ferum_bot.bookreuse.viewmodels.authentication.ConfirmRecoverCodeViewModel
import com.github.ferum_bot.bookreuse.viewmodels.authentication.SignInViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Matvey Popov.
 * Date: 27.02.2021
 * Time: 23:34
 * Project: BookReuse
 */
@Module
abstract class MainActivityViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    abstract fun bindSignInViewModel(viewModel: SignInViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ConfirmRecoverCodeViewModel::class)
    abstract fun bindConfirmRecoverCodeViewModel(viewModel: ConfirmRecoverCodeViewModel): ViewModel
}