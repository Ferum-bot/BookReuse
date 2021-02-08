package com.github.ferum_bot.bookreuse.viewmodels.preview_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Matvey Popov.
 * Date: 08.02.2021
 * Time: 17:52
 * Project: BookReuse
 */
class PreviewScreenViewModelFactory: ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PreviewScreenViewModel::class.java)) {
            return PreviewScreenViewModel() as T
        }
        throw IllegalArgumentException("Invalid View model to create: $modelClass")
    }
}