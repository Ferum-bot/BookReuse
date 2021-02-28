package com.github.ferum_bot.bookreuse.core.models.interfaces

import androidx.annotation.StringRes

/**
 * Created by Matvey Popov.
 * Date: 28.02.2021
 * Time: 20:24
 * Project: BookReuse
 */
interface ResourceProvider {

    fun string(@StringRes id: Int): String

    fun <T> string(@StringRes id: Int, parameter: T): String

}