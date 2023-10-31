package com.danilkharytonov.composecontacts.domain.model

import com.danilkharytonov.composecontacts.data.database.MAIN_USER_ID
import com.danilkharytonov.composecontacts.data.database.MainUserEntity

data class User(
    var uuid: String,
    var name: String,
    var surname: String,
    var phoneNumber: String,
    var email: String,
    var dateOfBirth: String,
    var iconImage: String,
    var category: String? = null
)

fun User.toMainUserEntity(): MainUserEntity {
    return MainUserEntity(
        uuid = MAIN_USER_ID,
        name = name,
        surname = surname,
        phoneNumber = phoneNumber,
        email = email,
        dateOfBirth = dateOfBirth,
        iconImage = iconImage
    )
}