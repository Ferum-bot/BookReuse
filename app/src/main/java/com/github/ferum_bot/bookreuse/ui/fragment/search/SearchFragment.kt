package com.github.ferum_bot.bookreuse.ui.fragment.search

import androidx.fragment.app.Fragment
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentSearchScreenBinding
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding

/**
 * Created by Matvey Popov.
 * Date: 19.02.2021
 * Time: 23:05
 * Project: BookReuse
 */
class SearchFragment: Fragment(R.layout.fragment_search_screen) {

    private val binding by viewBinding { FragmentSearchScreenBinding.bind(it) }

}