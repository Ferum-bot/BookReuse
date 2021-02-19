package com.github.ferum_bot.bookreuse.ui.fragment.messages

import androidx.fragment.app.Fragment
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentMessagesScreenBinding
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding

/**
 * Created by Matvey Popov.
 * Date: 19.02.2021
 * Time: 23:04
 * Project: BookReuse
 */
class MessagesFragment: Fragment(R.layout.fragment_messages_screen) {

    private val binding by viewBinding { FragmentMessagesScreenBinding.bind(it) }

}