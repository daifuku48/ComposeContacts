package com.danilkharytonov.composecontacts.presentation.main_user_view

import com.danilkharytonov.composecontacts.domain.use_cases.main_user_view.GetMainUserUseCase
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator

class MainUserViewModel(
    reducer: MainUserReducer,
    useCases: List<GetMainUserUseCase>,
    appNavigator: Navigator
) : BaseViewModel<MainUserEvent, MainUserState>(reducer, useCases, appNavigator) {
    init {
        handleEvent(MainUserEvent.UserLoading)
    }

    override fun createInitialState(): MainUserState {
        return MainUserState()
    }
}