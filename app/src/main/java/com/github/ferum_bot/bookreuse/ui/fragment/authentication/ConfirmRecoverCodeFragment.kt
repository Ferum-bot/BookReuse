package com.github.ferum_bot.bookreuse.ui.fragment.authentication

import android.animation.LayoutTransition
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.viewModels
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.core.extensions.convertDpToPixels
import com.github.ferum_bot.bookreuse.core.models.TimeFormatter
import com.github.ferum_bot.bookreuse.databinding.FragmentConfirmRecoverCodeBinding
import com.github.ferum_bot.bookreuse.di.components.MainActivityComponent
import com.github.ferum_bot.bookreuse.ui.activity.MainActivity
import com.github.ferum_bot.bookreuse.ui.fragment.base.BaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.base.MainActivityBaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding
import com.github.ferum_bot.bookreuse.viewmodels.authentication.ConfirmRecoverCodeViewModel

/**
 * Created by Matvey Popov.
 * Date: 28.02.2021
 * Time: 20:07
 * Project: BookReuse
 */
class ConfirmRecoverCodeFragment: MainActivityBaseFragment(R.layout.fragment_confirm_recover_code) {

    private val component by lazy { activityComponent.authorizationComponent().build() }

    private val binding by viewBinding { FragmentConfirmRecoverCodeBinding.bind(it) }

    private val viewModel by viewModels<ConfirmRecoverCodeViewModel> { activityComponent.viewModelFactory() }

    private val timer = object: CountDownTimer(TIMER_DURATION_IN_MILLIS, TIMER_COUNT_DOWN_INTERVAL_IN_MILLIS) {

        override fun onTick(millisUntilFinished: Long) {
            binding.resendCodeButton.apply {
                text = TimeFormatter.formatTime(
                    millisUntilFinished,
                    getString(R.string.send_again) + "\n"
                )
            }
        }

        override fun onFinish() {
            enableRepeatedCodeSend()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureAnimations()
        configureViews()
    }

    override fun onStart() {
        super.onStart()

        setUpTimerForCodeRecovering()
    }

    override fun onResume() {
        super.onResume()

        timer.start()
    }

    private fun configureViews() {
        binding.recoveryDescription.text = getString(R.string.confirm_recover_code_description, TIMER_DURATION_IN_SECONDS.toString())
        binding.resendCodeButton.apply {
            isEnabled = false
            text = TimeFormatter.formatTime(
                TIMER_DURATION_IN_MILLIS,
                getString(R.string.send_again) + "\n"
            )
            layoutParams.height = FrameLayout.LayoutParams.WRAP_CONTENT
            setTextColor(getColor(R.color.base_gray))
        }
    }

    private fun configureAnimations() {
        val layoutTransition = binding.mainViewGroup.layoutTransition
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
    }

    private fun enableRepeatedCodeSend() {
        viewModel.isAllowedToSendCode = true
        binding.resendCodeButton.apply {
            layoutParams.height = resources.getDimension(R.dimen.orange_button_layout_height).toInt().convertDpToPixels(requireContext())
            isEnabled = true
            text = getString(R.string.send_again)
            setTextColor(getColor(R.color.base_orange))
        }
    }

    private fun setUpTimerForCodeRecovering() {

    }

    companion object {
        private const val TIMER_DURATION_IN_SECONDS = 45L
        private const val TIMER_DURATION_IN_MILLIS = TIMER_DURATION_IN_SECONDS * 1000
        private const val TIMER_COUNT_DOWN_INTERVAL_IN_MILLIS = 1000L
    }
}