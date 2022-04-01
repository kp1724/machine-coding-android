package com.gopay.dependencies

import com.gopay.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create() : MainActivityComponent
    }

    fun inject(activity: MainActivity)
}