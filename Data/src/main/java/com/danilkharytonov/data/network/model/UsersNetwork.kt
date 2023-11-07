package com.danilkharytonov.data.network.model

import com.google.gson.annotations.SerializedName

internal data class UsersNetwork(
    @SerializedName("results")
    val userList: List<UserNetwork>
)