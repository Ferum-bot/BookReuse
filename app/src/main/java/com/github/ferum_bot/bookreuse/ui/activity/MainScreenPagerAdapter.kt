package com.github.ferum_bot.bookreuse.ui.activity

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.ferum_bot.bookreuse.ui.fragment.about_application.AboutApplicationFragment
import com.github.ferum_bot.bookreuse.ui.fragment.home_screen.HomeScreenFragment
import com.github.ferum_bot.bookreuse.ui.fragment.messages.AnonimusUserMessagesScreenFragment
import com.github.ferum_bot.bookreuse.ui.fragment.messages.MessagesScreenFragment
import com.github.ferum_bot.bookreuse.ui.fragment.profile.AnonimusUserProfileScreenFragment
import com.github.ferum_bot.bookreuse.ui.fragment.profile.ProfileScreenFragment
import com.github.ferum_bot.bookreuse.ui.fragment.search.SearchScreenFragment
import com.github.ferum_bot.bookreuse.ui.interfaces.AuthorizationUtil

/**
 * Created by Matvey Popov.
 * Date: 25.02.2021
 * Time: 22:52
 * Project: BookReuse
 */
class MainScreenPagerAdapter(
    activity: MainActivity,
    private val authorizationUtil: AuthorizationUtil
 ): FragmentStateAdapter(activity) {

    private val isUserAuthorized: Boolean
        get() = authorizationUtil.isUserAuthorized()

    override fun getItemCount(): Int =
        NUMBER_OB_MAIN_SCREENS

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            POSITION_OF_HOME_FRAGMENT -> {
                HomeScreenFragment()
            }
            POSITION_OF_SEARCH_FRAGMENT -> {
                SearchScreenFragment()
            }
            POSITION_OF_MESSAGES_FRAGMENT -> {
                if (isUserAuthorized) {
                    MessagesScreenFragment()
                }
                else {
                    AnonimusUserMessagesScreenFragment()
                }
            }
            POSITION_OF_PROFILE_FRAGMENT -> {
                if (isUserAuthorized) {
                    ProfileScreenFragment()
                }
                else {
                    AnonimusUserProfileScreenFragment()
                }
            }
            else -> {
                throw IllegalArgumentException("Unknown position to create fragment: $position")
            }
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