package com.danilkharytonov.composecontacts.presentation.base

interface Reducer<State: UiState, Event: UiEvent> {
    fun reduce(state: State, event: Event): State
}