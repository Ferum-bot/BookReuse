package com.github.ferum_bot.bookreuse.core.models

import android.os.Parcelable
import com.github.ferum_bot.bookreuse.core.models.interfaces.HomeScreenListItem
import kotlinx.android.parcel.Parcelize

/**
 * Created by Matvey Popov.
 * Date: 05.03.2021
 * Time: 23:21
 * Project: BookReuse
 */
data class ListOfAdvertTypesItem(
    val id: Int,
    val listOfTypes: List<String>
): HomeScreenListItem {

    override val itemId: Int
        get() = id

}