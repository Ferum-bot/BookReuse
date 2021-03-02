package com.github.ferum_bot.bookreuse.di.modules

import androidx.lifecycle.ViewModel
import com.github.ferum_bot.bookreuse.di.annotations.ViewModelKey
import com.github.ferum_bot.bookreuse.viewmodels.authentication.*
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

    @Binds
    @IntoMap
    @ViewModelKey(RecoveryPasswordViewModel::class)
    abstract fun bindRecoveryPasswordViewModel(viewModel: RecoveryPasswordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StartRegistrationViewModel::class)
    abstract fun bindStartRegistrationViewModel(viewModel: StartRegistrationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GeneralInformationViewModel::class)
    abstract fun bindGeneralInformationViewModel(viewModel: GeneralInformationViewModel): ViewModel
}