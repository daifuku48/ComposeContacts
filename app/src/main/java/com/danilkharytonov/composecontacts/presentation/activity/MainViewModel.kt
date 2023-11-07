package com.danilkharytonov.composecontacts.presentation.activity

import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.domain.use_cases.main_activity.MainActivityEvent
import com.danilkharytonov.domain.use_cases.main_activity.MainActivityReducer
import com.danilkharytonov.domain.use_cases.main_activity.MainActivityState

class MainViewModel(
    reducer: MainActivityReducer,
    useCases: List<com.danilkharytonov.core.base.UseCase<MainActivityState, MainActivityEvent>>,
    appNavigator: Navigator
) : BaseViewModel<MainActivityEvent, MainActivityState>(reducer, useCases, appNavigator) {

    init {
        handleEvent(MainActivityEvent.CheckExistingUser)
    }

    override fun createInitialState(): MainActivityState {
        return MainActivityState()
    }

    override fun handleSpecialEvent(event: MainActivityEvent) {}
}