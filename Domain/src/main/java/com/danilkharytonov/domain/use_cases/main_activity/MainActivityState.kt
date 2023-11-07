package com.danilkharytonov.domain.use_cases.main_activity

import com.danilkharytonov.core.base.UiState

data class MainActivityState(
    val startDestination: String? = null,
    val isLoading: Boolean = true
) : UiState