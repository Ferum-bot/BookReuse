package com.github.ferum_bot.bookreuse.viewmodels.authentication

import androidx.lifecycle.ViewModel
import com.github.ferum_bot.bookreuse.core.models.interfaces.ResourceProvider
import javax.inject.Inject

/**
 * Created by Matvey Popov.
 * Date: 27.02.2021
 * Time: 23:03
 * Project: BookReuse
 */
class SignInViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider
): ViewModel() {

}