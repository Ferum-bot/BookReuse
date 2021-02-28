package com.github.ferum_bot.bookreuse.core.models.implementations

import android.content.Context
import com.github.ferum_bot.bookreuse.core.models.interfaces.ResourceProvider
import javax.inject.Inject

/**
 * Created by Matvey Popov.
 * Date: 28.02.2021
 * Time: 20:25
 * Project: BookReuse
 */
class AndroidResourceProvider @Inject constructor(
    private val appContext: Context
):ResourceProvider {

    override fun string(id: Int): String =
        appContext.getString(id)

    override fun <T> string(id: Int, parameter: T): String =
        appContext.getString(id, parameter)
}