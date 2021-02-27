package com.github.ferum_bot.bookreuse.di.modules

import com.github.ferum_bot.bookreuse.di.components.CreatingNewStuffActivityComponent
import com.github.ferum_bot.bookreuse.di.components.LaunchActivityComponent
import com.github.ferum_bot.bookreuse.di.components.MainActivityComponent
import dagger.Module

/**
 * Created by Matvey Popov.
 * Date: 27.02.2021
 * Time: 23:07
 * Project: BookReuse
 */
@Module(subcomponents = [
    MainActivityComponent::class,
    LaunchActivityComponent::class,
    CreatingNewStuffActivityComponent::class
])
class AppSubcomponents