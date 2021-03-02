package com.github.ferum_bot.bookreuse.ui.fragment.base

import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.github.ferum_bot.bookreuse.di.components.MainActivityComponent
import com.github.ferum_bot.bookreuse.ui.activity.MainActivity
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding

/**
 * Created by Matvey Popov.
 * Date: 02.03.2021
 * Time: 19:46
 * Project: BookReuse
 */
abstract class MainActivityBaseFragment(
    @LayoutRes
    layoutId: Int,
): BaseFragment(layoutId) {

    protected val activityComponent: MainActivityComponent
        get()  {
            val activity = requireActivity() as MainActivity
            return activity.component
        }

}