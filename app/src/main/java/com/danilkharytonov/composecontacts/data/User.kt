package com.danilkharytonov.composecontacts.data

data class User(
    var name: String,
    var surname: String,
    var phoneNumber: String,
    var email: String,
    var dateOfBirth: String,
    var iconImage: String
)
