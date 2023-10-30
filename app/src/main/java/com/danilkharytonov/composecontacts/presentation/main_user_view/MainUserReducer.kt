package com.danilkharytonov.composecontacts.presentation.main_user_view

import com.danilkharytonov.composecontacts.presentation.base.Reducer

class MainUserReducer : Reducer<MainUserState, MainUserEvent> {
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
                isLoading = false)
            is MainUserEvent.UserLoading -> state.copy(isLoading = true)
            MainUserEvent.Error -> state.copy(isLoading = false)
        }
    }
}