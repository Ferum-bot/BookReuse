package com.github.ferum_bot.bookreuse.ui.fragment.base

import android.content.ActivityNotFoundException
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.ui.interfaces.ShowToasts

/**
 * Created by Matvey Popov.
 * Date: 23.02.2021
 * Time: 23:36
 * Project: BookReuse
 */
abstract class BaseFragment(@LayoutRes id: Int): Fragment(id), ShowToasts{


    /**
     * Add custom successful toast lately
     */
    override fun showSuccessfulMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccessfulMessage(messageId: Int) {
        val message = getString(messageId)
        showSuccessfulMessage(message)
    }

    /**
     * Add custom unsuccessful toast lately
     */
    override fun showUnsuccessfulMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showUnsuccessfulMessage(messageId: Int) {
        val message = getString(messageId)
        showUnsuccessfulMessage(message)
    }

    protected fun startIntentWithCatchingExceptions(additionMessage: String? = null, blockOfCode: () -> Unit) {
        try {
            blockOfCode.invoke()
        }
        catch (ex: ActivityNotFoundException) {
            val baseMessage = getString(R.string.base_message_for_no_activity_exception)
            val message = StringBuilder().append(baseMessage)
            if (additionMessage != null) {
                message.append(" $additionMessage")
            }
            showUnsuccessfulMessage(message.toString())
        }
    }

    protected fun getColor(@ColorRes id: Int): Int =
        ContextCompat.getColor(requireContext(), id)
}