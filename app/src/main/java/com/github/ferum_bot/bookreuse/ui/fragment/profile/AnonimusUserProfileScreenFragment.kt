package com.github.ferum_bot.bookreuse.ui.fragment.profile

import androidx.fragment.app.Fragment
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentNotAuthorizationProfileScreenBinding
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding

/**
 * Created by Matvey Popov.
 * Date: 22.02.2021
 * Time: 21:59
 * Project: BookReuse
 */
class AnonimusUserProfileScreenFragment: Fragment(R.layout.fragment_not_authorization_profile_screen) {

    private val binding by viewBinding { FragmentNotAuthorizationProfileScreenBinding.bind(it) }

}