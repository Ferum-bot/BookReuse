package com.github.ferum_bot.bookreuse.ui.fragment.authentication

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.View
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentConfirmRecoverCodeBinding
import com.github.ferum_bot.bookreuse.ui.activity.MainActivity
import com.github.ferum_bot.bookreuse.ui.fragment.base.BaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding

/**
 * Created by Matvey Popov.
 * Date: 28.02.2021
 * Time: 20:07
 * Project: BookReuse
 */
class ConfirmRecoverCodeFragment: BaseFragment(R.layout.fragment_confirm_recover_code) {

    private val component by lazy {
        val activity = requireActivity() as MainActivity
        val component = activity.component.authorizationComponent()
        return@lazy component.build()
    }

    private val binding by viewBinding { FragmentConfirmRecoverCodeBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureAnimations()
    }

    private fun configureAnimations() {
        val layoutTransition = binding.mainViewGroup.layoutTransition
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
    }
}