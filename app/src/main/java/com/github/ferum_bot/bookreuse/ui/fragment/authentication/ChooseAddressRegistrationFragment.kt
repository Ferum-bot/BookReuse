package com.github.ferum_bot.bookreuse.ui.fragment.authentication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentChooseAddressRegistrationBinding
import com.github.ferum_bot.bookreuse.ui.activity.MainActivity
import com.github.ferum_bot.bookreuse.ui.fragment.base.BaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.base.MainActivityBaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding
import com.github.ferum_bot.bookreuse.viewmodels.authentication.ChooseAddressRegistrationViewModel
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.search.SearchFactory

/**
 * Created by Matvey Popov.
 * Date: 02.03.2021
 * Time: 19:40
 * Project: BookReuse
 */
class ChooseAddressRegistrationFragment: MainActivityBaseFragment(R.layout.fragment_choose_address_registration) {

    private val component by lazy { activityComponent.authorizationComponent().build() }

    private val binding by viewBinding { FragmentChooseAddressRegistrationBinding.bind(it) }

    private val viewModel by viewModels<ChooseAddressRegistrationViewModel> { activityComponent.viewModelFactory() }

    override fun onStart() {
        super.onStart()

        startMapView()
    }

    override fun onStop() {
        super.onStop()

        stopMapView()
    }

    private fun startMapView() {
        configureMapView()
        MapKitFactory.getInstance().onStart()
        binding.mapView.visibility = View.VISIBLE
        binding.mapView.onStart()
    }

    private fun configureMapView() {
        binding.mapView.map.isNightModeEnabled = true
    }

    private fun stopMapView() {
        binding.mapView.onStop()
        binding.mapView.visibility = View.GONE
        MapKitFactory.getInstance().onStop()
    }
}