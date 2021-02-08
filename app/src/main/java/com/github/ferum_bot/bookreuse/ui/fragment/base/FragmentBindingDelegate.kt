package com.github.ferum_bot.bookreuse.ui.fragment.base

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by Matvey Popov.
 * Date: 08.02.2021
 * Time: 17:36
 * Project: BookReuse
 */
class FragmentBindingDelegate<T: ViewBinding>(
    val fragment: Fragment,
    private val bindingFactory: (View) -> T
): ReadOnlyProperty<Fragment, T> {
    private var binding: T? = null

    init {
        fragment.lifecycle.addObserver(object: LifecycleEventObserver {

            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if (event == Lifecycle.Event.ON_CREATE) {
                    fragment.viewLifecycleOwnerLiveData.observe(fragment) { lifecycleOwner ->
                        lifecycleOwner.lifecycle.addObserver(object: LifecycleEventObserver {

                            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                                if (event == Lifecycle.Event.ON_DESTROY) {
                                    binding = null
                                }
                            }

                        })
                    }
                }
            }

        })
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val binding = binding
        if (binding != null) {
            return binding
        }

        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw IllegalStateException("Should not initialize binding when fragment view are destroyed")
        }
        return bindingFactory.invoke(thisRef.requireView())
            .also {  this@FragmentBindingDelegate.binding = it }
    }
}