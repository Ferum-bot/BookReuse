package com.github.ferum_bot.bottom_navigation_view.core.extensions

import android.content.Context

/**
 * Created by Matvey Popov.
 * Date: 21.02.2021
 * Time: 23:27
 * Project: BookReuse
 */
internal fun Context.dpToPx(dp: Int): Float {
    return dp.toFloat() * resources.displayMetrics.density
}