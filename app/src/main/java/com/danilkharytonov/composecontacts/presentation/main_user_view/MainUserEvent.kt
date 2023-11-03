package com.danilkharytonov.composecontacts.presentation.main_user_view

import com.danilkharytonov.composecontacts.domain.model.User
import com.danilkharytonov.composecontacts.presentation.base.navigation.UiEvent

sealed class MainUserEvent : UiEvent {
    object UserLoading : MainUserEvent()
    object NavigateToEditingUserEvent : MainUserEvent()
    object NavigateToContactsScreen : MainUserEvent()
    data class UserLoaded(val user: User) : MainUserEvent()
    object Error : MainUserEvent()
}