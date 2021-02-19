package com.github.ferum_bot.bookreuse.ui.fragment.delegates

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Created by Matvey Popov.
 * Date: 08.02.2021
 * Time: 17:43
 * Project: BookReuse
 */

fun <T: ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) =
    FragmentBindingDelegate(this, viewBindingFactory)