package com.github.ferum_bot.bookreuse.ui.fragment.profile

import androidx.fragment.app.Fragment
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentProfileScreenContainerBinding
import com.github.ferum_bot.bookreuse.ui.fragment.base.BaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding

/**
 * Created by Matvey Popov.
 * Date: 19.02.2021
 * Time: 23:05
 * Project: BookReuse
 */
class ProfileScreenFragment: BaseFragment(R.layout.fragment_profile_screen_container) {

    private val binding by viewBinding { FragmentProfileScreenContainerBinding.bind(it) }

}