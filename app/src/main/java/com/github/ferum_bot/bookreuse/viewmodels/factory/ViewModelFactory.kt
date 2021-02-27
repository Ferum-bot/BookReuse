package com.github.ferum_bot.bookreuse.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.ferum_bot.bookreuse.di.scopes.ViewModelsScope
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Matvey Popov.
 * Date: 19.02.2021
 * Time: 21:02
 * Project: BookReuse
 */
@ViewModelsScope
class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModelProvider = viewModels[modelClass] ?:
            throw IllegalArgumentException("ViewModel not found: $modelClass")
        return viewModelProvider.get() as T
    }

}