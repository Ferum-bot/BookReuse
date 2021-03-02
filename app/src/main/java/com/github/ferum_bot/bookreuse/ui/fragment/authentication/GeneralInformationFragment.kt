package com.github.ferum_bot.bookreuse.ui.fragment.authentication

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentGeneralInformationRegistrationBinding
import com.github.ferum_bot.bookreuse.databinding.FragmentStartRegistrationBinding
import com.github.ferum_bot.bookreuse.ui.activity.MainActivity
import com.github.ferum_bot.bookreuse.ui.fragment.base.BaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.base.MainActivityBaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding
import com.github.ferum_bot.bookreuse.viewmodels.authentication.GeneralInformationViewModel
import com.github.ferum_bot.bookreuse.viewmodels.authentication.StartRegistrationViewModel

/**
 * Created by Matvey Popov.
 * Date: 02.03.2021
 * Time: 19:11
 * Project: BookReuse
 */

class GeneralInformationFragment: MainActivityBaseFragment(R.layout.fragment_general_information_registration) {

    private val component by lazy { activityComponent.authorizationComponent().build() }

    private val binding by viewBinding { FragmentGeneralInformationRegistrationBinding.bind(it) }

    private val viewModel by viewModels<GeneralInformationViewModel> { activityComponent.viewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAnimations()
    }

    private fun setUpAnimations() {
        val layoutTransition = binding.mainViewGroup.layoutTransition
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
    }
}