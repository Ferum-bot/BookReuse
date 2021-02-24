package com.github.ferum_bot.bookreuse.ui.interfaces

import androidx.annotation.StringRes

/**
 * Created by Matvey Popov.
 * Date: 23.02.2021
 * Time: 23:33
 * Project: BookReuse
 */
interface ShowToasts {

    fun showSuccessfulMessage(message: String)
    fun showSuccessfulMessage(@StringRes messageId: Int)

    fun showUnsuccessfulMessage(message: String)
    fun showUnsuccessfulMessage(@StringRes messageId: Int)
}