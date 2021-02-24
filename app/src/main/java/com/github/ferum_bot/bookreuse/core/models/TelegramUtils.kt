package com.github.ferum_bot.bookreuse.core.models

import android.net.Uri
import com.github.ferum_bot.bookreuse.network.NetworkUtils
import com.github.ferum_bot.bookreuse.network.enums.Schema

/**
 * Created by Matvey Popov.
 * Date: 24.02.2021
 * Time: 22:59
 * Project: BookReuse
 */
object TelegramUtils {

    private const val BASE_URL = "t.me/"

    fun getBrowserLinkToUser(userNickname: String): Uri {
        val correctNickname = validateUserNickname(userNickname)
        val schema = Schema.HTTPS.value
        val link = schema + NetworkUtils.schemeSeparator + BASE_URL + correctNickname
        return Uri.parse(link)
    }

    private fun validateUserNickname(nickname: String): String {
        if (nickname.startsWith("/@")) {
            return nickname.removeRange(0, 2)
        }
        if (nickname.startsWith("@")) {
            return nickname.removeRange(0, 1)
        }
        return nickname
    }

}