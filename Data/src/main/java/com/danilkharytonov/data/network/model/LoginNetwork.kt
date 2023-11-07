package com.danilkharytonov.data.network.model

import com.google.gson.annotations.SerializedName

internal data class LoginNetwork(
    @SerializedName("uuid")
    val uuid: String
)