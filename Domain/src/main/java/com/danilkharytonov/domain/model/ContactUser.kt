package com.danilkharytonov.domain.model

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