package com.github.ferum_bot.bookreuse.di.components

import dagger.Subcomponent

/**
 * Created by Matvey Popov.
 * Date: 28.02.2021
 * Time: 20:20
 * Project: BookReuse
 */
@Subcomponent
interface AuthorizationComponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): AuthorizationComponent
    }
}