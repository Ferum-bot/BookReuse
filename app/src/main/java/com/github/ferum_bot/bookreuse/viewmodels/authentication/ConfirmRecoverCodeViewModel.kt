package com.github.ferum_bot.bookreuse.viewmodels.authentication

import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by Matvey Popov.
 * Date: 28.02.2021
 * Time: 21:51
 * Project: BookReuse
 */
class ConfirmRecoverCodeViewModel @Inject constructor(

): ViewModel() {

    var isAllowedToSendCode: Boolean = false

}