package com.danilkharytonov.domain.use_cases.create_user_view

import com.danilkharytonov.core.base.UiState

data class CreateUserState(
    val uuid: String = "",
    val name: String = "",
    val surname: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val dateOfBirth: String = "",
    val iconImage: String = ""
) : UiState