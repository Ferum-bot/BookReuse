package com.github.ferum_bot.bookreuse.ui.fragment.advert

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentAdvertScreenBinding
import com.github.ferum_bot.bookreuse.ui.fragment.base.MainActivityBaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding

/**
 * Created by Matvey Popov.
 * Date: 07.03.2021
 * Time: 16:18
 * Project: BookReuse
 */
class AdvertMainScreenFragment: MainActivityBaseFragment(R.layout.fragment_advert_screen) {

    private val binding by viewBinding { FragmentAdvertScreenBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureToolbar()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val toolbar = binding.toolBar
        toolbar.inflateMenu(R.menu.advert_main_screen_menu)
    }

    private fun configureToolbar() {
        binding.toolBar.setTitleTextColor(getColor(R.color.base_white))
    }
}