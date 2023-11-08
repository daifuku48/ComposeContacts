package com.danilkharytonov.composecontacts.presentation.edit_profile_screen

data class EditProfileUiState(
    val name: String = "",
    val surname: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val date: String = "",
    val iconImage: String = ""
)