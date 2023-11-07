package com.danilkharytonov.composecontacts.presentation.activity

import com.danilkharytonov.core.base.BaseViewModel
import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.core.base.navigation.Navigator

class MainViewModel(
    reducer: MainActivityReducer,
    useCases: List<UseCase<MainActivityState, MainActivityEvent>>,
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