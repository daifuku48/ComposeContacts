package com.danilkharytonov.composecontacts.presentation.create_user_view

import com.danilkharytonov.composecontacts.presentation.base.Reducer

class CreateUserReducer : Reducer<CreateUserState, CreateUserEvent> {
    override fun reduce(state: CreateUserState, event: CreateUserEvent): CreateUserState {
        return when (event) {
            is CreateUserEvent.SaveUserEvent -> state
            is CreateUserEvent.UserSaved -> state
            is CreateUserEvent.Error -> state
            is CreateUserEvent.NameChangedEvent -> state.copy(name = event.name)
            is CreateUserEvent.SurnameChangedEvent -> state.copy(surname = event.surname)
            is CreateUserEvent.PhoneChangedEvent -> state.copy(phoneNumber = event.phone)
            is CreateUserEvent.EmailChangedEvent -> state.copy(email = event.email)
            is CreateUserEvent.DateOfBirthChangedEvent -> state.copy(dateOfBirth = event.data)
            is CreateUserEvent.IconChangedEvent -> state.copy(iconImage = event.icon)
        }
    }

}