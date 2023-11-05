package com.danilkharytonov.composecontacts.data.network.model

import com.google.gson.annotations.SerializedName

data class LoginNetwork(
    @SerializedName("uuid")
    val uuid: String
)