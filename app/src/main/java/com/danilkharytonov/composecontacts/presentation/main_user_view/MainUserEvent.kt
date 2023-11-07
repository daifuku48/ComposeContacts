package com.danilkharytonov.composecontacts.presentation.main_user_view

import com.danilkharytonov.core.base.UiEvent
import com.danilkharytonov.domain.model.User

sealed class MainUserEvent : UiEvent {
    object UserLoading : MainUserEvent()
    data class UserLoaded(val user: User) : MainUserEvent()
    object Error : MainUserEvent()
}