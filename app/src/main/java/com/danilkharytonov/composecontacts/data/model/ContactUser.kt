package com.danilkharytonov.composecontacts.data.model

import com.danilkharytonov.composecontacts.data.database.model.SubUserEntity
import com.danilkharytonov.composecontacts.domain.model.Category

data class ContactUser(
    var uuid: String,
    var name: String,
    var surname: String,
    var phoneNumber: String,
    var email: String,
    var dateOfBirth: String,
    var iconImage: String,
    var category: Category
)

fun ContactUser.toEntity(): SubUserEntity {
    return SubUserEntity(
        uuid = uuid,
        name = name,
        surname = surname,
        phoneNumber = phoneNumber,
        email = email,
        dateOfBirth = dateOfBirth,
        iconImage = iconImage,
        category = category
    )
}