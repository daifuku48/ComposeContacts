package com.danilkharytonov.composecontacts.presentation.main_user_view

import com.danilkharytonov.composecontacts.presentation.base.Reducer

class MainUserReducer : Reducer<MainUserState, MainUserEvent> {
    override fun reduce(state: MainUserState, event: MainUserEvent): MainUserState {
        return when(event){
            is MainUserEvent.UserIsEmpty -> state
            is MainUserEvent.UserLoaded -> state.copy(user = event.user)
            is MainUserEvent.UserLoading -> state
            MainUserEvent.Error -> state
        }
    }
}