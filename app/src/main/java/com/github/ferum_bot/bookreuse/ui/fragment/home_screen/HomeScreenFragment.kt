package com.github.ferum_bot.bookreuse.ui.fragment.home_screen

import androidx.fragment.app.Fragment
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentHomeScreenBinding
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding

/**
 * Created by Matvey Popov.
 * Date: 19.02.2021
 * Time: 21:47
 * Project: BookReuse
 */
class HomeScreenFragment: Fragment(R.layout.fragment_home_screen) {

    private val binding by viewBinding { FragmentHomeScreenBinding.bind(it) }

}