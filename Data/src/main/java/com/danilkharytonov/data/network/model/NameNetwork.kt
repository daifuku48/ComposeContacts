package com.danilkharytonov.data.network.model

import com.google.gson.annotations.SerializedName

internal data class NameNetwork(
    @SerializedName("first")
    val firstName: String,
    @SerializedName("last")
    val lastName: String
)