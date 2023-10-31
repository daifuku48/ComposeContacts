package com.danilkharytonov.composecontacts.presentation.base

import com.danilkharytonov.composecontacts.presentation.base.navigation.UiEvent

interface Reducer<State : UiState, Event : UiEvent> {
    fun reduce(state: State, event: Event): State
}