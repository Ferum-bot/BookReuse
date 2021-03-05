package com.github.ferum_bot.bookreuse.core.models

import android.os.Parcelable
import com.github.ferum_bot.bookreuse.core.models.interfaces.HomeScreenListItem
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by Matvey Popov.
 * Date: 05.03.2021
 * Time: 23:17
 * Project: BookReuse
 */
data class AdvertSmallItem(
    val id: Int,
    val title: String,
    val author: String,
    val date: Date,
    val imageUrl: String,
    val isLiked: Boolean
): HomeScreenListItem {

    override val itemId: Int
        get() = id

}