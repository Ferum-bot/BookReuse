package com.github.ferum_bot.bookreuse.ui.fragment.authentication

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
        binding.mapView.onStart()
        MapKitFactory.getInstance().onStart()
    }

    private fun stopMapView() {
        binding.mapView.onStop()
        MapKitFactory.getInstance().onStop()
    }
}