package com.danilkharytonov.composecontacts.presentation.create_user_view

import com.danilkharytonov.domain.use_cases.create_user_view.CreateUserState

data class CreateUserUiState(
    val uuid: String = "",
    val name: String = "",
    val surname: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val dateOfBirth: String = "",
    val iconImage: String = ""
)

fun CreateUserState.toUi() : CreateUserUiState{
    return CreateUserUiState(
        uuid = uuid,
        name = name,
        surname = surname,
        phoneNumber = phoneNumber,
        email = email,
        dateOfBirth = dateOfBirth,
        iconImage = iconImage
    )
}