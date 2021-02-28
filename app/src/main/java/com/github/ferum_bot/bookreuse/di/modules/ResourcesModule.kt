package com.github.ferum_bot.bookreuse.di.modules

import com.github.ferum_bot.bookreuse.core.models.implementations.AndroidResourceProvider
import com.github.ferum_bot.bookreuse.core.models.interfaces.ResourceProvider
import dagger.Binds
import dagger.Module

/**
 * Created by Matvey Popov.
 * Date: 27.02.2021
 * Time: 23:27
 * Project: BookReuse
 */
@Module
abstract class ResourcesModule {

    @Binds
    abstract fun bindResourceProvider(provider: AndroidResourceProvider): ResourceProvider

}