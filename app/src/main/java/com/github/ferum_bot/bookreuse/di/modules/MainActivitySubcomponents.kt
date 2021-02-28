package com.github.ferum_bot.bookreuse.di.modules

import com.github.ferum_bot.bookreuse.di.components.AuthorizationComponent
import dagger.Module

/**
 * Created by Matvey Popov.
 * Date: 28.02.2021
 * Time: 20:21
 * Project: BookReuse
 */
@Module(subcomponents = [
    AuthorizationComponent::class,
])
class MainActivitySubcomponents