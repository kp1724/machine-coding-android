package com.gopay.responses


import com.google.gson.annotations.SerializedName

data class StarWarsResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val starWarsPeople: List<StarWarsPeople>
)