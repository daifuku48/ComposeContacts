package com.danilkharytonov.composecontacts.presentation.main_user_view

data class MainUserUiState (
    val uuid: String? = null,
    val name: String? = null,
    val surname: String? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
    val dateOfBirth: String? = null,
    val iconImage: String? = null,
    val isLoading: Boolean = false
)