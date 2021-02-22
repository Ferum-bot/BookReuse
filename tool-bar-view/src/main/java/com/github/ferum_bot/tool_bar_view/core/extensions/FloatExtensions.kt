package com.github.ferum_bot.tool_bar_view.core.extensions

/**
 * Created by Matvey Popov.
 * Date: 22.02.2021
 * Time: 21:07
 * Project: BookReuse
 */
/**
 * This function is necessary because
 * stroke line in dp is too big
 */
internal fun Float.refactorToBookReuseWidth() =
    this / 5.0f