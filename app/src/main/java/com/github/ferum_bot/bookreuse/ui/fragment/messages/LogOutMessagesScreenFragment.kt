package com.github.ferum_bot.bookreuse.ui.fragment.messages

import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentNotAuthorizationMessagesScreenBinding
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding

/**
 * Created by Matvey Popov.
 * Date: 22.02.2021
 * Time: 20:29
 * Project: BookReuse
 */
class LogOutMessagesScreenFragment: Fragment(R.layout.fragment_not_authorization_messages_screen) {

    private val binding by viewBinding { FragmentNotAuthorizationMessagesScreenBinding.bind(it) }

    override fun onStart() {
        super.onStart()

        configureToolBar()
    }

    private fun configureToolBar() {
        binding.toolBar.setTitleTextColor(ContextCompat.getColor(requireContext(), R.color.base_white))
    }
}