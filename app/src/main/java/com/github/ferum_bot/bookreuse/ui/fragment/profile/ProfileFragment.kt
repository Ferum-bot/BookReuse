package com.github.ferum_bot.bookreuse.ui.fragment.profile

import androidx.fragment.app.Fragment
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentProfileScreenBinding
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding

/**
 * Created by Matvey Popov.
 * Date: 19.02.2021
 * Time: 23:05
 * Project: BookReuse
 */
class ProfileFragment: Fragment(R.layout.fragment_profile_screen) {

    private val binding by viewBinding { FragmentProfileScreenBinding.bind(it) }

}