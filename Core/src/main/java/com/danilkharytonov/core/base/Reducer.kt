package com.danilkharytonov.core.base

interface Reducer<State : UiState, Event : UiEvent> {
    fun reduce(state: State, event: Event): State
}