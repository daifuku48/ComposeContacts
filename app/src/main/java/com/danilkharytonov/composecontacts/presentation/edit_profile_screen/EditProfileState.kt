package com.danilkharytonov.composecontacts.presentation.edit_profile_screen

import com.danilkharytonov.composecontacts.presentation.base.UiState

data class EditProfileState(
    val name: String = "",
    val surname: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val date: String = "",
    val iconImage: String = ""
) : UiState