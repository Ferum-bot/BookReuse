package com.github.ferum_bot.bookreuse.ui.fragment.authentication

import android.Manifest
import android.animation.LayoutTransition
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentGeneralInformationRegistrationBinding
import com.github.ferum_bot.bookreuse.ui.fragment.base.MainActivityBaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding
import com.github.ferum_bot.bookreuse.viewmodels.authentication.GeneralInformationViewModel

/**
 * Created by Matvey Popov.
 * Date: 02.03.2021
 * Time: 19:11
 * Project: BookReuse
 */

class GeneralInformationFragment: MainActivityBaseFragment(R.layout.fragment_general_information_registration) {

    private val component by lazy { activityComponent.authorizationComponent().build() }

    private val binding by viewBinding { FragmentGeneralInformationRegistrationBinding.bind(it) }

    private val viewModel by viewModels<GeneralInformationViewModel> { activityComponent.viewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAnimations()
    }

    override fun onStart() {
        super.onStart()

        setAllClickListeners()
    }

    private fun setUpAnimations() {
        val layoutTransition = binding.mainViewGroup.layoutTransition
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
    }

    private fun setAllClickListeners() {
        binding.chooseAddressEditText.setOnClickListener {
            this::openChooseAddressFragmentOrRequestPermission.invoke()
        }

        binding.mapPlaceholder.setOnClickListener {
            this::openChooseAddressFragmentOrRequestPermission.invoke()
        }
    }

    private fun openChooseAddressFragmentOrRequestPermission() {
        if (geolocationIsNotAvailable()) {
             requestGeolocationPermission()
             return
        }
        // NAVIGATE TO SCREEN
    }

    private fun geolocationIsNotAvailable(): Boolean {
        val context = requireContext()
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            return false
        }
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            return false
        }
        return true
    }

    private fun requestGeolocationPermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            PERMISSION_REQUEST_ACCESS_CODE
        )
    }

    companion object {
        private const val PERMISSION_REQUEST_ACCESS_CODE = 1
    }
}