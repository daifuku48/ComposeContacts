package com.danilkharytonov.composecontacts.presentation.activity

import com.danilkharytonov.composecontacts.domain.use_cases.main_activity.CheckingExistingUserUseCase
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator

class MainViewModel(
    reducer: MainActivityReducer,
    useCases: List<CheckingExistingUserUseCase>,
    appNavigator: Navigator
) : BaseViewModel<MainActivityEvent, MainActivityState>(reducer, useCases, appNavigator) {

    init {
        handleEvent(MainActivityEvent.CheckExistingUser)
    }

    override fun createInitialState(): MainActivityState {
        return MainActivityState()
    }
}