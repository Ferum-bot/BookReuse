package com.github.ferum_bot.bookreuse.ui.fragment.authentication

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentRecoveryPasswordBinding
import com.github.ferum_bot.bookreuse.ui.activity.MainActivity
import com.github.ferum_bot.bookreuse.ui.fragment.base.BaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.base.MainActivityBaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding
import com.github.ferum_bot.bookreuse.viewmodels.authentication.RecoveryPasswordViewModel

/**
 * Created by Matvey Popov.
 * Date: 02.03.2021
 * Time: 17:54
 * Project: BookReuse
 */
class RecoveryPasswordFragment: MainActivityBaseFragment(R.layout.fragment_recovery_password) {

    private val component by lazy { activityComponent.authorizationComponent().build() }

    private val binding by viewBinding { FragmentRecoveryPasswordBinding.bind(it) }

    private val viewModel by viewModels<RecoveryPasswordViewModel> { activityComponent.viewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAnimations()
    }

    override fun onStart() {
        super.onStart()

        setAllClickListeners()
        setAllEditTextListeners()
    }

    private fun setUpAnimations() {
        val layoutTransitions = binding.mainViewGroup.layoutTransition
        layoutTransitions.enableTransitionType(LayoutTransition.CHANGING)
    }

    private fun setAllClickListeners() {

    }

    private fun setAllEditTextListeners() {

    }
}