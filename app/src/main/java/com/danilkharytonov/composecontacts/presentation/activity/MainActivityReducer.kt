package com.danilkharytonov.composecontacts.presentation.activity

import com.danilkharytonov.core.base.Reducer
import com.danilkharytonov.core.base.navigation.Screen

class MainActivityReducer : Reducer<MainActivityState, MainActivityEvent> {
    override fun reduce(state: MainActivityState, event: MainActivityEvent): MainActivityState {
        return when (event) {
            is MainActivityEvent.CheckExistingUser -> state
            is MainActivityEvent.UserIsExist -> state.copy(
                startDestination = Screen.MAIN_USER_SCREEN,
                isLoading = false
            )

            is MainActivityEvent.UserIsNotExist -> state.copy(
                startDestination = Screen.CREATE_USER_SCREEN,
                isLoading = false
            )
        }
    }
}