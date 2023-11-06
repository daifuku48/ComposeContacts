package com.danilkharytonov.composecontacts.presentation.main_user_view

import com.danilkharytonov.composecontacts.domain.use_cases.main_user_view.GetMainUserUseCase
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.Screen
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator

class MainUserViewModel(
    reducer: MainUserReducer,
    useCases: List<GetMainUserUseCase>,
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