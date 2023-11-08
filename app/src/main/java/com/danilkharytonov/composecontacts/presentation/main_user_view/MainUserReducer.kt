package com.danilkharytonov.composecontacts.presentation.main_user_view

import com.danilkharytonov.core.base.Reducer
import com.danilkharytonov.domain.use_cases.main_user_view.MainUserEvent
import com.danilkharytonov.domain.use_cases.main_user_view.MainUserState

class MainUserReducer : Reducer<MainUserState, MainUserEvent, MainUserUiState> {
    override fun reduce(state: MainUserState, event: MainUserEvent): MainUserState {
        return when (event) {
            is MainUserEvent.UserLoaded -> state.copy(
                uuid = event.user.uuid,
                name = event.user.name,
                surname = event.user.surname,
                phoneNumber = event.user.phoneNumber,
                email = event.user.email,
                dateOfBirth = event.user.dateOfBirth,
                iconImage = event.user.iconImage,
                isLoading = false
            )

            is MainUserEvent.UserLoading -> state.copy(isLoading = true)
            is MainUserEvent.Error -> state.copy(isLoading = false)
        }
    }

    override fun mapToUiModel(state: MainUserState): MainUserUiState {
        return MainUserUiState(
            uuid = state.uuid,
            name = state.name,
            surname = state.surname,
            email = state.email,
            phoneNumber = state.phoneNumber,
            dateOfBirth = state.dateOfBirth,
            iconImage = state.iconImage,
            isLoading = state.isLoading
        )
    }
}