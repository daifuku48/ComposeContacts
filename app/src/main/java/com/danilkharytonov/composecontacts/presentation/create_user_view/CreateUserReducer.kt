package com.danilkharytonov.composecontacts.presentation.create_user_view

import com.danilkharytonov.composecontacts.presentation.base.Reducer

class CreateUserReducer : Reducer<CreateUserState, CreateUserEvent> {
    override fun reduce(state: CreateUserState, event: CreateUserEvent): CreateUserState {
        return when (event) {
            is CreateUserEvent.SaveUserEvent -> state.copy(savedUser = state.savedUser)
            is CreateUserEvent.UserSaved -> state
            is CreateUserEvent.Error -> state
            is CreateUserEvent.NameChangedEvent -> state.copy(savedUser = state.savedUser.copy(name = event.name))
            is CreateUserEvent.SurnameChangedEvent -> state.copy(
                savedUser = state.savedUser.copy(
                    surname = event.surname
                )
            )

            is CreateUserEvent.PhoneChangedEvent -> state.copy(
                savedUser = state.savedUser.copy(
                    phoneNumber = event.phone
                )
            )

            is CreateUserEvent.EmailChangedEvent -> state.copy(
                savedUser = state.savedUser.copy(
                    email = event.email
                )
            )

            is CreateUserEvent.DateOfBirthChangedEvent -> state.copy(
                savedUser = state.savedUser.copy(
                    dateOfBirth = event.data
                )
            )

            is CreateUserEvent.IconChangedEvent -> state.copy(
                savedUser = state.savedUser.copy(
                    iconImage = event.icon
                )
            )
        }
    }

}