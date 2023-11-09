package com.danilkharytonov.composecontacts.presentation.uimodel

import com.danilkharytonov.domain.model.ContactUser

data class UiContactUser(
    var uuid: String,
    var name: String,
    var surname: String,
    var phoneNumber: String,
    var email: String,
    var dateOfBirth: String,
    var iconImage: String,
    var category: UiCategory
)


fun ContactUser.toUi() : UiContactUser {
    return UiContactUser(
        uuid = uuid,
        name = name,
        surname = surname,
        phoneNumber = phoneNumber,
        email = email,
        dateOfBirth = dateOfBirth,
        iconImage = iconImage,
        category = category.toUi()
    )
}

fun UiContactUser.toDomain(): ContactUser {
    return ContactUser(
        uuid = uuid,
        name = name,
        surname = surname,
        phoneNumber = phoneNumber,
        email = email,
        dateOfBirth = dateOfBirth,
        iconImage = iconImage,
        category = category.toDomain()
    )
}