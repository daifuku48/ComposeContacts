package com.danilkharytonov.composecontacts.presentation.edit_profile_screen

import com.danilkharytonov.composecontacts.presentation.base.navigation.UiEvent

sealed class EditProfileEvent : UiEvent {
    object SaveEditingUser : EditProfileEvent()
    object GetMainUserEvent : EditProfileEvent()
    object EditingUserSavedEvent: EditProfileEvent()
    object NavigateToProfileScreenEvent: EditProfileEvent()
    data class EditNameEvent(val name: String) : EditProfileEvent()
    data class EditSurnameEvent(val surname: String) : EditProfileEvent()
    data class EditPhoneEvent(val phone: String) : EditProfileEvent()
    data class EditEmailEvent(val email: String) : EditProfileEvent()
    data class EditBirthEvent(val birth: String) : EditProfileEvent()
    data class EditIconEvent(val imageIcon: String) : EditProfileEvent()
    object ErrorEvent: EditProfileEvent()
}