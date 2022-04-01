package com.moneyer.usecase

import com.moneyer.responses.StarWarsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {

    @GET("/api/people")
    fun  getPeopleList(): Call<StarWarsResponse>

}