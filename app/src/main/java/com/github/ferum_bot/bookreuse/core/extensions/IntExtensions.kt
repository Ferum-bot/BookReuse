package com.github.ferum_bot.bookreuse.core.extensions

import android.content.Context
import android.util.TypedValue

/**
 * Created by Matvey Popov.
 * Date: 28.02.2021
 * Time: 22:35
 * Project: BookReuse
 */

fun Int.convertDpToPixels(context: Context): Int {
    val result = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics)
    return result.toInt()
}