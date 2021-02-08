package com.github.ferum_bot.bookreuse.ui.fragment.preview_screen

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.databinding.FragmentPreviewScreenBinding
import com.github.ferum_bot.bookreuse.ui.fragment.base.viewBinding
import com.github.ferum_bot.bookreuse.viewmodels.preview_screen.PreviewScreenViewModel
import com.github.ferum_bot.bookreuse.viewmodels.preview_screen.PreviewScreenViewModelFactory
import kotlin.system.exitProcess

/**
 * Created by Matvey Popov.
 * Date: 08.02.2021
 * Time: 14:08
 * Project: BookReuse
 */
class PreviewScreenFragment: Fragment(R.layout.fragment_preview_screen) {

    private val binding by viewBinding { FragmentPreviewScreenBinding.bind(it) }
    private val viewModel by viewModels<PreviewScreenViewModel> { PreviewScreenViewModelFactory() }

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
               exitProcess(0)
            }
        })
    }

    private companion object {
        private const val TIMER_START_DELAY = 500L
        private const val TIMER_COUNT_DOWN_INTERVAL = 500L
    }
}