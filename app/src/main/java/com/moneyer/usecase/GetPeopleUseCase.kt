package com.moneyer.usecase

import com.moneyer.responses.StarWarsResponse
import javax.inject.Inject

class GetPeopleUseCase @Inject constructor(private val apiClient: ApiClient) : BaseRepository() {
    private var next = ""
    private var prev = ""

    suspend fun getPeople(onSuccess: (StarWarsResponse) -> Unit, onFailure: (Throwable) -> Unit) {
        val result = safeCall { apiClient.getPeopleList() }
        result.onSuccess {
            next = it.next ?: ""
            prev = it.previous ?: ""
            onSuccess.invoke(it)
        }
        result.onFailure(onFailure)
    }
}