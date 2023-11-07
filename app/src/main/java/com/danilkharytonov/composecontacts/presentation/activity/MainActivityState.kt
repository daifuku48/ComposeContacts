package com.danilkharytonov.composecontacts.presentation.activity

import com.danilkharytonov.core.base.UiState

data class MainActivityState(
    val startDestination: String? = null,
    val isLoading: Boolean = true
) : UiState