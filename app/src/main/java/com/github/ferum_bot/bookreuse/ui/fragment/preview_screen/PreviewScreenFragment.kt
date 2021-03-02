package com.github.ferum_bot.bookreuse.ui.fragment.preview_screen

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentPreviewScreenBinding
import com.github.ferum_bot.bookreuse.ui.activity.LaunchActivity
import com.github.ferum_bot.bookreuse.ui.fragment.base.BaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding
import com.github.ferum_bot.bookreuse.viewmodels.factory.ViewModelFactory
import com.github.ferum_bot.bookreuse.viewmodels.preview_screen.PreviewScreenViewModel

/**
 * Created by Matvey Popov.
 * Date: 08.02.2021
 * Time: 14:08
 * Project: BookReuse
 */
class PreviewScreenFragment: BaseFragment(R.layout.fragment_preview_screen) {

    private val binding by viewBinding { FragmentPreviewScreenBinding.bind(it) }

    /**
     * Needed to start preview animation with some delay
     * to look more beautiful
     */
    private val timer = object: CountDownTimer(TIMER_START_DELAY, TIMER_COUNT_DOWN_INTERVAL) {

        override fun onTick(millisUntilFinished: Long) {

        }

        override fun onFinish() {
            startPreviewAnimation()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnEndAnimationListener()
    }

    override fun onResume() {
        super.onResume()

        timer.start()
    }

    private fun startPreviewAnimation() {
        binding.motionLayout.transitionToEnd()
    }

    private fun setOnEndAnimationListener() {
        binding.motionLayout.addTransitionListener(object: MotionLayout.TransitionListener {

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {

            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {

            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {

            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                val activity = requireActivity() as LaunchActivity
                activity.splashScreenHasShown()
            }
        })
    }

    private companion object {
        private const val TIMER_START_DELAY = 600L
        private const val TIMER_COUNT_DOWN_INTERVAL = 600L
    }
}