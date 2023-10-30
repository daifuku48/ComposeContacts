package com.danilkharytonov.composecontacts.presentation.create_user_view

import com.danilkharytonov.composecontacts.domain.model.User
import com.danilkharytonov.composecontacts.presentation.base.UiState

data class CreateUserState(
    val savedUser: User = User(
        uuid = "",
        name = "",
        surname = "",
        phoneNumber = "",
        email = "",
        dateOfBirth = "",
        iconImage = ""
    )
) : UiState