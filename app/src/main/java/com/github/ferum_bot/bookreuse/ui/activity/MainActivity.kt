package com.github.ferum_bot.bookreuse.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.core.view.iterator
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.ActivityMainBinding

/**
 * Created by Matvey Popov.
 * Date: 19.02.2021
 * Time: 21:13
 * Project: BookReuse
 */
class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        setUpBottomNavigation()
    }

    private fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    private fun setUpBottomNavigation() {
        val bottomNav = binding.bottomNavigation
        val navController = findNavController(binding.navHostFragment.id)
        bottomNav.setupWithNavController(navController)

        bottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem) {

            }
            true
        }
    }

    companion object {
        private const val POSITION_OF_HOME_ITEM = 0
        private const val POSITION_OF_SEARCH_ITEM = 1
        private const val POSITION_OF_ADD_ITEM = 2
        private const val POSITION_OF_MESSAGES_ITEM = 3
        private const val POSITION_OF_PROFILE_ITEM = 4
    }
}