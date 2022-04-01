package com.gopay.dependencies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gopay.usecase.GetPeopleUseCase
import com.gopay.viewmodel.MainActivityViewModel
import com.gopay.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
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