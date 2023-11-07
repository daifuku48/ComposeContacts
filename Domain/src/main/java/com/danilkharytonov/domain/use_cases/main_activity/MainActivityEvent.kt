package com.danilkharytonov.domain.use_cases.main_activity

import com.danilkharytonov.core.base.UiEvent

sealed class MainActivityEvent : UiEvent {
    object UserIsExist : MainActivityEvent()
    object UserIsNotExist : MainActivityEvent()
    object CheckExistingUser : MainActivityEvent()
}