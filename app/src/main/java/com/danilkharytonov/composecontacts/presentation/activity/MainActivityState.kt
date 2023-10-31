package com.danilkharytonov.composecontacts.presentation.activity

import com.danilkharytonov.composecontacts.presentation.base.UiState

data class MainActivityState(
    val startDestination: String? = null,
    val isLoading: Boolean = true
) : UiState