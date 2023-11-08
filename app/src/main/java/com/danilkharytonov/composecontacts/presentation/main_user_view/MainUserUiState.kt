package com.danilkharytonov.composecontacts.presentation.main_user_view

import com.danilkharytonov.core.base.UiState
import com.danilkharytonov.domain.use_cases.main_user_view.MainUserState

data class MainUserUiState (
    val uuid: String? = null,
    val name: String? = null,
    val surname: String? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
    val dateOfBirth: String? = null,
    val iconImage: String? = null,
    val isLoading: Boolean = false
): UiState

fun MainUserState.toUi() : MainUserUiState{
    return MainUserUiState(
        uuid = uuid,
        name = name,
        surname = surname,
        email = email,
        phoneNumber = phoneNumber,
        dateOfBirth = dateOfBirth,
        iconImage = iconImage,
        isLoading = isLoading
    )
}