package com.github.ferum_bot.bookreuse.ui.fragment.search

import androidx.fragment.app.Fragment
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentSearchScreenContainerBinding
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding

/**
 * Created by Matvey Popov.
 * Date: 19.02.2021
 * Time: 23:05
 * Project: BookReuse
 */
class SearchScreenFragment: Fragment(R.layout.fragment_search_screen_main) {

    private val binding by viewBinding { FragmentSearchScreenContainerBinding.bind(it) }

}