package com.moneyer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moneyer.customviews.FullScreenViewType
import com.moneyer.usecase.GetPeopleUseCase
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase
): ViewModel() {

    private val responseLiveData: MutableLiveData<FullScreenViewType> = MutableLiveData()
    private var next = ""
    private var prev = ""

    fun responseLiveData(): LiveData<FullScreenViewType> = responseLiveData

    fun getPeople() {
        responseLiveData.value = FullScreenViewType.LoadingView
        getPeopleUseCase.getPeople(
            onSuccess = {
                next = it.next ?: ""
                prev = it.previous ?: ""
                responseLiveData.postValue(FullScreenViewType.ResponseView(it.starWarsPeople))
            },
            onFailure = {
                responseLiveData.postValue(FullScreenViewType.ErrorView)
                it.printStackTrace()
            })
    }

}