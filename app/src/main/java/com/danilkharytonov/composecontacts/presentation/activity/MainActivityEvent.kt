package com.danilkharytonov.composecontacts.presentation.activity

import com.danilkharytonov.composecontacts.presentation.base.navigation.UiEvent

sealed class MainActivityEvent : UiEvent {
    object UserIsExist : MainActivityEvent()
    object UserIsNotExist : MainActivityEvent()
    object CheckExistingUser : MainActivityEvent()
}