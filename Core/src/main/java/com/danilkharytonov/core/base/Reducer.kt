package com.danilkharytonov.core.base

interface Reducer<State : UiState, Event : UiEvent, UiModel> {
    fun reduce(state: State, event: Event): State
    fun mapToUiModel(state: State) : UiModel
}