package com.moneyer.usecase

import com.moneyer.responses.StarWarsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GetPeopleUseCase @Inject constructor(private val apiClient: ApiClient) {

    fun getPeople(onSuccess:(StarWarsResponse) -> Unit, onFailure: (Throwable) -> Unit) {
        apiClient.getPeopleList().enqueue(object : Callback<StarWarsResponse> {
            override fun onResponse(
                call: Call<StarWarsResponse>,
                response: Response<StarWarsResponse>
            ) {
                if(response.isSuccessful && response.body()!=null) {
                    onSuccess.invoke(response.body()!!)
                }
            }

            override fun onFailure(call: Call<StarWarsResponse>, t: Throwable) {
                onFailure.invoke(t)
            }

        })
    }
}