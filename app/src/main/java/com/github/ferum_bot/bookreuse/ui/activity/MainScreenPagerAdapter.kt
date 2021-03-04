package com.github.ferum_bot.bookreuse.ui.activity

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.ferum_bot.bookreuse.ui.fragment.about_application.AboutApplicationFragment
import com.github.ferum_bot.bookreuse.ui.fragment.authentication.ChooseAddressRegistrationFragment
import com.github.ferum_bot.bookreuse.ui.fragment.authentication.GeneralInformationFragment
import com.github.ferum_bot.bookreuse.ui.fragment.home_screen.HomeScreenContainerFragment
import com.github.ferum_bot.bookreuse.ui.fragment.home_screen.HomeScreenFragment
import com.github.ferum_bot.bookreuse.ui.fragment.messages.AnonimusUserMessagesScreenFragment
import com.github.ferum_bot.bookreuse.ui.fragment.messages.MessagesScreenContainerFragment
import com.github.ferum_bot.bookreuse.ui.fragment.messages.MessagesScreenFragment
import com.github.ferum_bot.bookreuse.ui.fragment.profile.AnonimusUserProfileScreenFragment
import com.github.ferum_bot.bookreuse.ui.fragment.profile.ProfileScreenContainerFragment
import com.github.ferum_bot.bookreuse.ui.fragment.profile.ProfileScreenFragment
import com.github.ferum_bot.bookreuse.ui.fragment.search.SearchScreenContainerFragment
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
               HomeScreenContainerFragment()
            }
            POSITION_OF_SEARCH_FRAGMENT -> {
                SearchScreenContainerFragment()
            }
            POSITION_OF_MESSAGES_FRAGMENT -> {
                MessagesScreenContainerFragment()
            }
            POSITION_OF_PROFILE_FRAGMENT -> {
                ProfileScreenContainerFragment()
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