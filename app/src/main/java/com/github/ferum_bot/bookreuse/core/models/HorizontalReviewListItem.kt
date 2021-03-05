package com.github.ferum_bot.bookreuse.core.models

import android.os.Parcelable
import com.github.ferum_bot.bookreuse.core.models.interfaces.HomeScreenListItem
import kotlinx.android.parcel.Parcelize

/**
 * Created by Matvey Popov.
 * Date: 05.03.2021
 * Time: 23:19
 * Project: BookReuse
 */
data class HorizontalReviewListItem(
    val id: Int,
    val titleLabel: String,
    val listOfSmallReviewItems: List<ReviewSmallItem>
): HomeScreenListItem {

    override val itemId: Int
        get() = id

}
