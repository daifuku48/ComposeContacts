package com.danilkharytonov.composecontacts.presentation.activity

import com.danilkharytonov.core.base.UiEvent

sealed class MainActivityEvent : UiEvent {
    object UserIsExist : MainActivityEvent()
    object UserIsNotExist : MainActivityEvent()
    object CheckExistingUser : MainActivityEvent()
}