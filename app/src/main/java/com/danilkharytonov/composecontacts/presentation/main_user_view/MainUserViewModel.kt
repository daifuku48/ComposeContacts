package com.danilkharytonov.composecontacts.presentation.main_user_view

import com.danilkharytonov.core.base.BaseViewModel
import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.core.base.navigation.Navigator
import com.danilkharytonov.core.base.navigation.Screen

class MainUserViewModel(
    reducer: MainUserReducer,
    useCases: List<UseCase<MainUserState, MainUserEvent>>,
    appNavigator: Navigator
) : BaseViewModel<MainUserEvent, MainUserState>(reducer, useCases, appNavigator) {

    override fun createInitialState(): MainUserState {
        return MainUserState()
    }

    override fun handleSpecialEvent(event: MainUserEvent) {}

    fun navigateToEditingScreen() {
        navigate(Screen.EDIT_PROFILE_SCREEN)
    }

    fun requestUserData() {
        handleEvent(MainUserEvent.UserLoading)
    }

    fun navigateToContactsScreen() {
        navigate(Screen.CONTACTS_SCREEN)
    }
}