package com.danilkharytonov.composecontacts.presentation.main_user_view

import com.danilkharytonov.composecontacts.domain.model.User
import com.danilkharytonov.composecontacts.presentation.base.UiState

data class MainUserState(
    val user: User = User(
        uuid = "",
        name = "",
        surname = "",
        phoneNumber = "",
        email = "",
        dateOfBirth = "",
        iconImage = ""
    ),
    val isLoading: Boolean = false,
    val isUserEmpty: Boolean = false
) : UiState