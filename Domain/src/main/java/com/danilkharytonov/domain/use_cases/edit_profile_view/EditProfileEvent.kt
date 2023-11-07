package com.danilkharytonov.domain.use_cases.edit_profile_view

sealed class EditProfileEvent : com.danilkharytonov.core.base.UiEvent {
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
    data class EditNameEvent(val name: String) : EditProfileEvent()
    data class EditSurnameEvent(val surname: String) : EditProfileEvent()
    data class EditPhoneEvent(val phone: String) : EditProfileEvent()
    data class EditEmailEvent(val email: String) : EditProfileEvent()
    data class EditBirthEvent(val birth: String) : EditProfileEvent()
    data class EditIconEvent(val imageIcon: String) : EditProfileEvent()
    object ErrorEvent : EditProfileEvent()
}