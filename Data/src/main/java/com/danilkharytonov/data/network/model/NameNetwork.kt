package com.danilkharytonov.data.network.model

import com.google.gson.annotations.SerializedName

data class NameNetwork(
    @SerializedName("first")
    val firstName: String,
    @SerializedName("last")
    val lastName: String
)