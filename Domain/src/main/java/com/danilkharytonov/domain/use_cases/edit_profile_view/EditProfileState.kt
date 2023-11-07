package com.danilkharytonov.domain.use_cases.edit_profile_view

import com.danilkharytonov.core.base.UiState

data class EditProfileState(
    val name: String = "",
    val surname: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val date: String = "",
    val iconImage: String = ""
) : UiState