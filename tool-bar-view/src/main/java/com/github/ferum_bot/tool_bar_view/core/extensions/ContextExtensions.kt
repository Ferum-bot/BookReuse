package com.github.ferum_bot.tool_bar_view.core.extensions

import android.content.Context

/**
 * Created by Matvey Popov.
 * Date: 22.02.2021
 * Time: 21:07
 * Project: BookReuse
 */
internal fun Context.dpToPx(dp: Int): Float {
    return dp.toFloat() * resources.displayMetrics.density
}