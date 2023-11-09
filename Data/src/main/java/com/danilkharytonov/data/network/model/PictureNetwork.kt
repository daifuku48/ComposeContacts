package com.danilkharytonov.data.network.model

import com.google.gson.annotations.SerializedName

internal data class PictureNetwork(
    @SerializedName("large")
    val iconImage: String
)