package com.github.ferum_bot.bookreuse.ui.fragment.home_screen.adapters

import androidx.recyclerview.widget.DiffUtil
import com.github.ferum_bot.bookreuse.core.models.interfaces.HomeScreenListItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

/**
 * Created by Matvey Popov.
 * Date: 05.03.2021
 * Time: 21:18
 * Project: BookReuse
 */
class MainHomeScreenAdapter: AsyncListDifferDelegationAdapter<HomeScreenListItem>(DIFF_CALL_BACK) {



    companion object {

        private val DIFF_CALL_BACK = object: DiffUtil.ItemCallback<HomeScreenListItem>() {
            override fun areItemsTheSame(oldItem: HomeScreenListItem, newItem: HomeScreenListItem): Boolean {
                return oldItem.itemId == newItem.itemId
            }

            override fun areContentsTheSame(oldItem: HomeScreenListItem, newItem: HomeScreenListItem): Boolean {
                return oldItem.equals(newItem)
            }
        }
    }
}