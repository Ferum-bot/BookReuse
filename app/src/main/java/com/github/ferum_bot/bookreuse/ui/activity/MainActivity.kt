package com.github.ferum_bot.bookreuse.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.application.MainApplication
import com.github.ferum_bot.bookreuse.databinding.ActivityMainBinding
import com.github.ferum_bot.bookreuse.ui.interfaces.AuthorizationUtil
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.map.Map
import com.yandex.mapkit.search.SearchFactory

/**
 * Created by Matvey Popov.
 * Date: 19.02.2021
 * Time: 21:13
 * Project: BookReuse
 */
class MainActivity: AppCompatActivity(), AuthorizationUtil {

    val component by lazy {
        val appComponent = (application as MainApplication).component
        val mainActivityComponent = appComponent.mainActivityComponent().build()
        mainActivityComponent.inject(this)
        return@lazy mainActivityComponent
    }

    private lateinit var binding: ActivityMainBinding

    private lateinit var createStuffBottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    private lateinit var viewPager: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        setContentView(binding.root)
        setUpAllViews()
        initYandexMapKit()
    }

    override fun onStart() {
        super.onStart()
        configureBottomSheet()
        setNavigationListenersToBottomNavigation()
        setAllClickListeners()
    }

    override fun isUserAuthorized(): Boolean {
        return false
    }

    override fun onBackPressed() {
        finish()
    }

    private fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    private fun setUpAllViews() {
        setUpBottomSheet()
        setUpViewPager()
    }

    private fun initYandexMapKit() {
        val apiKey = getString(R.string.yandex_map_kit_api_key)
        MapKitFactory.setApiKey(apiKey)
        MapKitFactory.initialize(this)
        SearchFactory.initialize(this)
    }

    private fun setUpBottomSheet() {
        val bottomSheet = findViewById<ConstraintLayout>(R.id.add_button_bottom_sheet)
        createStuffBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
    }

    private fun setUpViewPager() {
        val viewPagerAdapter = MainScreenPagerAdapter(this, this)
        viewPager = binding.viewpagerContainer.mainScreenViewPager
        viewPager.isUserInputEnabled = false
        viewPager.adapter = viewPagerAdapter
    }

    private fun configureBottomSheet() {
        createStuffBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        createStuffBottomSheetBehavior.skipCollapsed = true

        createStuffBottomSheetBehavior.addBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when(newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        setClickListenerForBackground()
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        binding.bottomAppBar.visibility = View.VISIBLE
                        removeClickListenerFromBackground()
                    }
                }
            }

            /**
             * May be add some animation lately
             */
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                binding.background.alpha = slideOffset
            }

        })
    }

    private fun setClickListenerForBackground() {
        binding.background.isClickable = true
        binding.background.setOnClickListener {
            createStuffBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    private fun removeClickListenerFromBackground() {
        binding.background.isClickable = false
        binding.background.setOnClickListener(null)
    }

    private fun setAllClickListeners() {
        binding.addStuffButton.setOnClickListener {
            binding.bottomAppBar.visibility = View.GONE
            createStuffBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        val announcementTextView = findViewById<TextView>(R.id.announcement_text_view)
        val announcementImage = findViewById<ImageView>(R.id.announcement_image)
        announcementTextView.setOnClickListener {
            clickListenerForCreateStuffButtons(TypesOfStuff.ANNOUNCEMENT)
        }
        announcementImage.setOnClickListener {
            clickListenerForCreateStuffButtons(TypesOfStuff.ANNOUNCEMENT)
        }

        val reviewTextView = findViewById<TextView>(R.id.review_text_view)
        val reviewImage = findViewById<ImageView>(R.id.review_image)
        reviewTextView.setOnClickListener {
            clickListenerForCreateStuffButtons(TypesOfStuff.REVIEW)
        }
        reviewImage.setOnClickListener {
            clickListenerForCreateStuffButtons(TypesOfStuff.REVIEW)
        }
    }

    private fun setNavigationListenersToBottomNavigation() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.profile_page_screen -> {
                    viewPager.currentItem = MainScreenPagerAdapter.POSITION_OF_PROFILE_FRAGMENT
                    true
                }
                R.id.home_page_screen -> {
                    viewPager.currentItem = MainScreenPagerAdapter.POSITION_OF_HOME_FRAGMENT
                    true
                }
                R.id.messages_page_screen -> {
                    viewPager.currentItem = MainScreenPagerAdapter.POSITION_OF_MESSAGES_FRAGMENT
                    true
                }
                R.id.search_page_screen -> {
                    viewPager.currentItem = MainScreenPagerAdapter.POSITION_OF_SEARCH_FRAGMENT
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun clickListenerForCreateStuffButtons(type: TypesOfStuff) {
        startCreatingNewStuffActivity(type)
    }

    private fun startCreatingNewStuffActivity(type: TypesOfStuff) {
        val intent = Intent(this, CreatingNewStuffActivity::class.java)
        when(type) {
            TypesOfStuff.REVIEW -> {
                intent.putExtra(STUFF_TYPE, TypesOfStuff.REVIEW.name)
            }
            TypesOfStuff.ANNOUNCEMENT -> {
                intent.putExtra(STUFF_TYPE, TypesOfStuff.ANNOUNCEMENT.name)
            }
        }
        startActivity(intent)
    }

    private enum class TypesOfStuff {
        REVIEW, ANNOUNCEMENT
    }

    companion object {
        private const val STUFF_TYPE = "stuff_type"
    }
}