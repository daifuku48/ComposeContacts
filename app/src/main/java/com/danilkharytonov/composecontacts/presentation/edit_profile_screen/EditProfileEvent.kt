package com.danilkharytonov.composecontacts.presentation.edit_profile_screen

import com.danilkharytonov.composecontacts.presentation.base.navigation.UiEvent

sealed class EditProfileEvent : UiEvent {
    object SaveEditingUser : EditProfileEvent()
    object GetMainUserEvent : EditProfileEvent()
    data class MainUserIsReceivedEvent(
        val name: String,
        val surname: String,
        val phone: String,
        val email: String,
        val birth: String,
        val imageIcon: String
    ) : EditProfileEvent()

    object EditingUserSavedEvent : EditProfileEvent()
    object NavigateToProfileScreenEvent : EditProfileEvent()
    data class EditNameEvent(val name: String) : EditProfileEvent()
    data class EditSurnameEvent(val surname: String) : EditProfileEvent()
    data class EditPhoneEvent(val phone: String) : EditProfileEvent()
    data class EditEmailEvent(val email: String) : EditProfileEvent()
    data class EditBirthEvent(val birth: String) : EditProfileEvent()
    data class EditIconEvent(val imageIcon: String) : EditProfileEvent()
    object ErrorEvent : EditProfileEvent()
}