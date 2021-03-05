package com.github.ferum_bot.bookreuse.ui.fragment.home_screen.delegate_adapters

import com.github.ferum_bot.bookreuse.core.models.AdvertSmallItem
import com.github.ferum_bot.bookreuse.core.models.HorizontalReviewListItem
import com.github.ferum_bot.bookreuse.core.models.ListOfAdvertTypesItem
import com.github.ferum_bot.bookreuse.core.models.interfaces.HomeScreenListItem
import com.github.ferum_bot.bookreuse.databinding.HorizontalLayoutWithTypesForAdvertGridBinding
import com.github.ferum_bot.bookreuse.databinding.HorizontalReviewListBinding
import com.github.ferum_bot.bookreuse.databinding.SmallAdvertItemBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

/**
 * Created by Matvey Popov.
 * Date: 05.03.2021
 * Time: 23:33
 * Project: BookReuse
 */
object MainHomeScreenDelegates {

    fun horizontalReviewListDelegate()
    = adapterDelegateViewBinding<HorizontalReviewListItem, HomeScreenListItem, HorizontalReviewListBinding>(
        { inflater, container -> HorizontalReviewListBinding.inflate(inflater, container, false) }
    ) {

    }

    fun listOfAdvertTypesDelegate()
    = adapterDelegateViewBinding<ListOfAdvertTypesItem, HomeScreenListItem, HorizontalLayoutWithTypesForAdvertGridBinding>(
        { inflater, container -> HorizontalLayoutWithTypesForAdvertGridBinding.inflate(inflater, container, false) }
    ) {

    }

    fun advertSmallGridItemDelegate()
    = adapterDelegateViewBinding<AdvertSmallItem, HomeScreenListItem, SmallAdvertItemBinding>(
        { inflater, container -> SmallAdvertItemBinding.inflate(inflater, container, false) }
    ) {

    }

}