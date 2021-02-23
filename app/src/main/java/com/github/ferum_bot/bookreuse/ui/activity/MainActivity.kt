package com.github.ferum_bot.bookreuse.ui.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.core.view.iterator
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.ActivityMainBinding
import com.github.ferum_bot.bookreuse.ui.fragment.home_screen.HomeScreenFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * Created by Matvey Popov.
 * Date: 19.02.2021
 * Time: 21:13
 * Project: BookReuse
 */
class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var createStuffBottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    /**
     * Needed to track current screen
     * in fragment container
     */
    private var currentScreen = Screens.HOME

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        setContentView(binding.root)
        setUpAllViews()
    }

    override fun onStart() {
        super.onStart()
        setUpBottomNavigation()
        configureBottomSheet()
        setAllClickListeners()
    }

    override fun onBackPressed() {
        finish()
    }

    private fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    private fun setUpAllViews() {
        val bottomSheet = findViewById<ConstraintLayout>(R.id.add_button_bottom_sheet)
        createStuffBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
    }

    private fun setUpBottomNavigation() {
        configureBottomNavigationOptions()

        binding.bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            val navController = findNavController(binding.navHostFragment.id)
            when(menuItem.itemId) {
                R.id.search_page_screen -> {
                    navigateToSearchScreen(navController)
                    true
                }
                R.id.profile_page_screen -> {
                    navigateToProfileScreen(navController)
                    true
                }
                R.id.messages_page_screen -> {
                    navigateToMessagesScreen(navController)
                    true
                }
                R.id.home_page_screen -> {
                    navigateToHomeScreen(navController)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun configureBottomNavigationOptions() {
        val bottomNav = binding.bottomNavigation
        val navController = findNavController(binding.navHostFragment.id)
        bottomNav.menu.getItem(POSITION_OF_ADD_ITEM).isEnabled = false
        bottomNav.setupWithNavController(navController)
    }

    private fun navigateToSearchScreen(navController: NavController) {
        when(currentScreen) {
            Screens.HOME -> {
                navController.navigate(R.id.action_homeScreenFragment_to_searchFragment)
            }
            Screens.MESSAGES -> {
                navController.navigate(R.id.action_messagesFragment_to_searchFragment)
            }
            Screens.PROFILE -> {
                navController.navigate(R.id.action_profileFragment_to_searchFragment)
            }
        }
        currentScreen = Screens.SEARCH
    }

    private fun navigateToProfileScreen(navController: NavController) {
        when(currentScreen) {
            Screens.HOME -> {
                navController.navigate(R.id.action_homeScreenFragment_to_profileFragment)
            }
            Screens.MESSAGES -> {
                navController.navigate(R.id.action_messagesFragment_to_profileFragment)
            }
            Screens.SEARCH -> {
                navController.navigate(R.id.action_searchFragment_to_profileFragment)
            }
        }
        currentScreen = Screens.PROFILE
    }

    private fun navigateToMessagesScreen(navController: NavController) {
        when(currentScreen) {
            Screens.HOME -> {
                navController.navigate(R.id.action_homeScreenFragment_to_messagesFragment)
            }
            Screens.SEARCH -> {
                navController.navigate(R.id.action_searchFragment_to_messagesFragment)
            }
            Screens.PROFILE -> {
                navController.navigate(R.id.action_profileFragment_to_messagesFragment)
            }
        }
        currentScreen = Screens.MESSAGES
    }

    private fun navigateToHomeScreen(navController: NavController) {
        when(currentScreen) {
            Screens.SEARCH -> {
                navController.navigate(R.id.action_searchFragment_to_homeScreenFragment)
            }
            Screens.MESSAGES -> {
                navController.navigate(R.id.action_messagesFragment_to_homeScreenFragment)
            }
            Screens.PROFILE -> {
                navController.navigate(R.id.action_profileFragment_to_homeScreenFragment)
            }
        }
        currentScreen = Screens.HOME
    }

    private fun configureBottomSheet() {
        createStuffBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        createStuffBottomSheetBehavior.skipCollapsed = true

        createStuffBottomSheetBehavior.addBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when(newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        binding.bottomNavigation.visibility = View.GONE
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        binding.bottomNavigation.visibility = View.VISIBLE
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

        })
    }

    private fun setAllClickListeners() {
        binding.addButton.setOnClickListener {
            binding.bottomNavigation.visibility = View.GONE
            createStuffBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    companion object {
        private const val POSITION_OF_HOME_ITEM = 0
        private const val POSITION_OF_SEARCH_ITEM = 1
        private const val POSITION_OF_ADD_ITEM = 2
        private const val POSITION_OF_MESSAGES_ITEM = 3
        private const val POSITION_OF_PROFILE_ITEM = 4
    }

    private enum class Screens{
        HOME, SEARCH, MESSAGES, PROFILE
    }
}