package com.danilkharytonov.composecontacts.presentation.create_user_view

import com.danilkharytonov.composecontacts.presentation.base.navigation.UiEvent


sealed class CreateUserEvent : UiEvent {
    object SaveUserEvent : CreateUserEvent()
    object UserSaved : CreateUserEvent()
    object Error : CreateUserEvent()

    data class NameChangedEvent(var name: String) : CreateUserEvent()
    data class SurnameChangedEvent(var surname: String) : CreateUserEvent()
    data class PhoneChangedEvent(var phone: String) : CreateUserEvent()
    data class EmailChangedEvent(var email: String) : CreateUserEvent()
    data class DateOfBirthChangedEvent(var data: String) : CreateUserEvent()
    data class IconChangedEvent(var icon: String) : CreateUserEvent()
}