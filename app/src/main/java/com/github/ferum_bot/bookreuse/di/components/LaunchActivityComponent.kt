package com.github.ferum_bot.bookreuse.di.components

import com.github.ferum_bot.bookreuse.ui.activity.LaunchActivity
import dagger.Subcomponent

/**
 * Created by Matvey Popov.
 * Date: 27.02.2021
 * Time: 23:08
 * Project: BookReuse
 */
@Subcomponent
interface LaunchActivityComponent {

    fun inject(activity: LaunchActivity)

    @Subcomponent.Builder
    interface Builder {

        fun build(): LaunchActivityComponent
    }
}