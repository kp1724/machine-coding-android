package com.moneyer.dependencies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moneyer.viewmodel.MainActivityViewModel
import com.moneyer.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun provideMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel
}