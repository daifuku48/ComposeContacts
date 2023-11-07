package com.danilkharytonov.data.network.model

import com.google.gson.annotations.SerializedName

data class DobNetwork(
    @SerializedName("date")
    val date: String
)