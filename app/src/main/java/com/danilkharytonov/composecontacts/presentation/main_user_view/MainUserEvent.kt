package com.danilkharytonov.composecontacts.presentation.main_user_view

import com.danilkharytonov.composecontacts.domain.model.User
import com.danilkharytonov.composecontacts.presentation.base.UiEvent

sealed class MainUserEvent : UiEvent {
    object UserIsEmpty : MainUserEvent()
    object UserLoading : MainUserEvent()
    data class UserLoaded(val user: User) : MainUserEvent()
    object Error : MainUserEvent()
}