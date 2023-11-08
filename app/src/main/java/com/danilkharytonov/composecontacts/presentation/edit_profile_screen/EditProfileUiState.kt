package com.danilkharytonov.composecontacts.presentation.edit_profile_screen

import com.danilkharytonov.domain.use_cases.edit_profile_view.EditProfileState

data class EditProfileUiState(
    val name: String = "",
    val surname: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val date: String = "",
    val iconImage: String = ""
)

fun EditProfileState.toUi(): EditProfileUiState {
    return EditProfileUiState(
        name = name,
        surname = surname,
        phoneNumber = phoneNumber,
        email = email,
        date = date,
        iconImage = iconImage
    )
}