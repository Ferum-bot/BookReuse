package com.github.ferum_bot.bookreuse.core.extensions

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

/**
 * Created by Matvey Popov.
 * Date: 23.02.2021
 * Time: 23:26
 * Project: BookReuse
 */
fun String.copyToClipboard(context: Context, label: String = "Label") {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(label, this)
    clipboard.setPrimaryClip(clip)
}