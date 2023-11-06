package com.danilkharytonov.composecontacts.presentation.edit_profile_screen

import com.danilkharytonov.composecontacts.presentation.base.Reducer

class EditProfileReducer : Reducer<EditProfileState, EditProfileEvent> {
    override fun reduce(state: EditProfileState, event: EditProfileEvent): EditProfileState {
        return when (event) {
            is EditProfileEvent.SaveEditingUser -> state
            is EditProfileEvent.EditingUserSavedEvent -> state
            is EditProfileEvent.GetMainUserEvent -> state
            is EditProfileEvent.MainUserIsReceivedEvent -> state.copy(
                name = event.name,
                surname = event.surname,
                phoneNumber = event.phone,
                email = event.email,
                date = event.birth,
                iconImage = event.imageIcon
            )

            is EditProfileEvent.ErrorEvent -> state
            is EditProfileEvent.EditNameEvent -> state.copy(name = event.name)
            is EditProfileEvent.EditSurnameEvent -> state.copy(surname = event.surname)
            is EditProfileEvent.EditPhoneEvent -> state.copy(phoneNumber = event.phone)
            is EditProfileEvent.EditEmailEvent -> state.copy(email = event.email)
            is EditProfileEvent.EditBirthEvent -> state.copy(date = event.birth)
            is EditProfileEvent.EditIconEvent -> state.copy(iconImage = event.imageIcon)
        }
    }
}