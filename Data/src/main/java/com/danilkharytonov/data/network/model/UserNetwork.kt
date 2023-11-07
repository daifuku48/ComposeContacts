package com.danilkharytonov.data.network.model

import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.model.ContactUser
import com.google.gson.annotations.SerializedName

data class UserNetwork(
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: NameNetwork,
    @SerializedName("login")
    val login: LoginNetwork,
    @SerializedName("picture")
    val picture: PictureNetwork,
    @SerializedName("phone")
    val phoneNumber: String,
    @SerializedName("dob")
    val dateOfBirth: DobNetwork
)

fun UserNetwork.toDomain(): ContactUser {
    return ContactUser(
        uuid = login.uuid,
        name = name.firstName,
        surname = name.lastName,
        phoneNumber = phoneNumber,
        email = email,
        dateOfBirth = dateOfBirth.date,
        iconImage = picture.iconImage,
        category = Category.ALL
    )
}