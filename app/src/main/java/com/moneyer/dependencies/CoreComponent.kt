package com.moneyer.dependencies

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        StorageModule::class,
        ImageModule::class,
        DispatcherModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): CoreComponent
    }

    fun mainActivityComponent(): MainActivityComponent.Factory

}
