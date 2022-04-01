package com.gopay.dependencies

import android.content.Context
import android.content.SharedPreferences
import androidx.room.RoomDatabase
import com.google.gson.Gson
import com.gopay.dispatcher.CoroutineDispatcherProvider
import com.gopay.viewmodel.MainActivityViewModel
import com.squareup.picasso.Picasso
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
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
