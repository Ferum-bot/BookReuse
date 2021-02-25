package com.github.ferum_bot.bookreuse.ui.activity

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.ferum_bot.bookreuse.ui.fragment.about_application.AboutApplicationFragment
import com.github.ferum_bot.bookreuse.ui.fragment.home_screen.HomeScreenFragment
import com.github.ferum_bot.bookreuse.ui.fragment.messages.MessagesScreenFragment
import com.github.ferum_bot.bookreuse.ui.fragment.profile.ProfileScreenFragment
import com.github.ferum_bot.bookreuse.ui.fragment.search.SearchScreenFragment

/**
 * Created by Matvey Popov.
 * Date: 25.02.2021
 * Time: 22:52
 * Project: BookReuse
 */
class MainScreenPagerAdapter(activity: MainActivity): FragmentStateAdapter(activity) {

    override fun getItemCount(): Int =
        NUMBER_OB_MAIN_SCREENS

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            POSITION_OF_HOME_FRAGMENT -> HomeScreenFragment()
            POSITION_OF_SEARCH_FRAGMENT -> SearchScreenFragment()
            POSITION_OF_MESSAGES_FRAGMENT -> MessagesScreenFragment()
            POSITION_OF_PROFILE_FRAGMENT -> AboutApplicationFragment()
            else ->
                throw IllegalArgumentException("Unknown position to create fragment: $position")
        }
    }

    companion object {
        private const val NUMBER_OB_MAIN_SCREENS = 4

        const val POSITION_OF_HOME_FRAGMENT = 0
        const val POSITION_OF_SEARCH_FRAGMENT = 1
        const val POSITION_OF_MESSAGES_FRAGMENT = 2
        const val POSITION_OF_PROFILE_FRAGMENT = 3
    }
}