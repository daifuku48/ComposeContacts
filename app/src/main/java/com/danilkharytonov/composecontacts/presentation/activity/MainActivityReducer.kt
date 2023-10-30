package com.danilkharytonov.composecontacts.presentation.activity

import com.danilkharytonov.composecontacts.presentation.base.Reducer

class MainActivityReducer : Reducer<MainActivityState, MainActivityEvent> {
    override fun reduce(state: MainActivityState, event: MainActivityEvent): MainActivityState {
        return when(event){
            is MainActivityEvent.CheckExistingUser -> state
            is MainActivityEvent.UserIsExist -> state.copy(userIsExist = true)
            is MainActivityEvent.UserIsNotExist -> state.copy(userIsExist = true)
        }
    }
}