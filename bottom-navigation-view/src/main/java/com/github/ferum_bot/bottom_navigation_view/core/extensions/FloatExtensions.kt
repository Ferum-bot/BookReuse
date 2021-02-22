package com.github.ferum_bot.bottom_navigation_view.core.extensions

/**
 * Created by Matvey Popov.
 * Date: 21.02.2021
 * Time: 23:50
 * Project: BookReuse
 */

/**
 * This function is necessary because
 * stroke line in dp is too big
 */
internal fun Float.refactorToBookReuseWidth() =
    this / 2.0f