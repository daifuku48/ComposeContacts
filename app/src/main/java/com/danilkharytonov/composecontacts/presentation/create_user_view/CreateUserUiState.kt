package com.danilkharytonov.composecontacts.presentation.create_user_view

data class CreateUserUiState(
    val uuid: String = "",
    val name: String = "",
    val surname: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val dateOfBirth: String = "",
    val iconImage: String = ""
)