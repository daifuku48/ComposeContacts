package com.danilkharytonov.domain.model

const val MAIN_USER_ID = "MAIN_USER_ID"

data class User(
    var uuid: String = MAIN_USER_ID,
    var name: String,
    var surname: String,
    var phoneNumber: String,
    var email: String,
    var dateOfBirth: String,
    var iconImage: String,
    var category: String? = null
)