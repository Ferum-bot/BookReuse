package com.github.ferum_bot.bookreuse.core.models

import android.os.Parcelable
import com.github.ferum_bot.bookreuse.core.enums.NumberOfStars
import com.github.ferum_bot.bookreuse.core.models.interfaces.HomeScreenListItem
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by Matvey Popov.
 * Date: 05.03.2021
 * Time: 23:17
 * Project: BookReuse
 */
data class ReviewSmallItem(
    val id: Int,
    val nickname: String,
    val date: Date,
    val rating: NumberOfStars,
    val profileImageUrl: String,
    val description: String,
    val numberOfLikes: Int,
    val numberOfDislikes: Int,
): HomeScreenListItem {

    override val itemId: Int
        get() = id

}
