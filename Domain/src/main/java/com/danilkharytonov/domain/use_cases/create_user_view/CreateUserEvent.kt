package com.danilkharytonov.domain.use_cases.create_user_view

sealed class CreateUserEvent : com.danilkharytonov.core.base.UiEvent {
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