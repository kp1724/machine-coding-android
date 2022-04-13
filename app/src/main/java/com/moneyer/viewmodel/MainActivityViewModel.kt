package com.moneyer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moneyer.customviews.FullScreenViewType
import com.moneyer.usecase.GetPeopleUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase
): ViewModel() {

    private val responseLiveData: MutableLiveData<FullScreenViewType> = MutableLiveData()

    fun responseLiveData(): LiveData<FullScreenViewType> = responseLiveData

    fun getPeople() {
        responseLiveData.value = FullScreenViewType.LoadingView
        //testing github action temp commit
        viewModelScope.launch {
            getPeopleUseCase.getPeople(
                onSuccess = {
                    responseLiveData.postValue(FullScreenViewType.ResponseView(it.starWarsPeople))
                },
                onFailure = {
                    responseLiveData.postValue(FullScreenViewType.ErrorView)
                    it.printStackTrace()
                })
        }
    }

}