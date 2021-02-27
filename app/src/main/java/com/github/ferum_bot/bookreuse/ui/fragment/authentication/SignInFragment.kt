package com.github.ferum_bot.bookreuse.ui.fragment.authentication

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentEntryToProfileBinding
import com.github.ferum_bot.bookreuse.ui.activity.MainActivity
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding
import com.github.ferum_bot.bookreuse.viewmodels.authentication.SignInViewModel

/**
 * Created by Matvey Popov.
 * Date: 27.02.2021
 * Time: 23:01
 * Project: BookReuse
 */
class SignInFragment: Fragment(R.layout.fragment_entry_to_profile) {

    private val binding by viewBinding { FragmentEntryToProfileBinding.bind(it) }

    private val viewModel by viewModels<SignInViewModel> {
        val activityComponent = (requireActivity() as MainActivity).component
        activityComponent.viewModelFactory()
    }

    override fun onStart() {
        super.onStart()

        setAllClickListeners()
        setAllTextChangeListeners()
    }

    private fun setAllClickListeners() {
        binding.enterButton.setOnClickListener {

        }

        binding.forgetPasswordButton.setOnClickListener {

        }

        binding.registrationButton.setOnClickListener {

        }

        binding.closeImageView.setOnClickListener {
            closeAuthorization()
        }
    }

    private fun setAllTextChangeListeners() {
        binding.inputEmailEditText.setOnKeyListener { view, keyCode, event ->
            true
        }

        binding.inputPasswordEditText.setOnKeyListener { view, keyCode, event ->

        }
    }

    private fun closeAuthorization() {

    }
}