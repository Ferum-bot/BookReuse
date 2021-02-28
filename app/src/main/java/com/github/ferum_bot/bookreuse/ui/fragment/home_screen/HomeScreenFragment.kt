package com.github.ferum_bot.bookreuse.ui.fragment.home_screen

import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentHomeScreenContainerBinding
import com.github.ferum_bot.bookreuse.ui.fragment.base.BaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding

/**
 * Created by Matvey Popov.
 * Date: 19.02.2021
 * Time: 21:47
 * Project: BookReuse
 */
class HomeScreenFragment: BaseFragment(R.layout.fragment_home_screen_container) {

    private val binding by viewBinding { FragmentHomeScreenContainerBinding.bind(it) }

    override fun onStart() {
        super.onStart()

        configureToolBar()
    }

    private fun configureToolBar() {
        binding.toolBar.setTitleTextColor(ContextCompat.getColor(requireContext(), R.color.base_white))
    }
}