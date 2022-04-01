package com.moneyer.dependencies

import com.moneyer.dispatcher.CoroutineDispatcherProvider
import com.moneyer.dispatcher.RealCoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DispatcherModule {
    @Provides
    @Singleton
    fun providesCoroutineDispatcher(): CoroutineDispatcherProvider {
        return RealCoroutineDispatcherProvider()
    }
}
