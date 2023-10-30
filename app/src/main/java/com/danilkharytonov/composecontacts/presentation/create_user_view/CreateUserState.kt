package com.danilkharytonov.composecontacts.presentation.create_user_view

import com.danilkharytonov.composecontacts.presentation.base.UiState

data class CreateUserState(
    val uuid: String = "",
    val name: String = "",
    val surname: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val dateOfBirth: String = "",
    val iconImage: String = "",
    val isError: Boolean = false
) : UiState