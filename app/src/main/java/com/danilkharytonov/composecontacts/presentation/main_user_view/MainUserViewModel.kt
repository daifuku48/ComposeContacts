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
    init {
        addSpecialEvent(MainUserEvent.NavigateToEditingUserEvent)
        addSpecialEvent(MainUserEvent.NavigateToContactsScreen)
    }

    override fun createInitialState(): MainUserState {
        return MainUserState()
    }

    private fun navigateToEditingScreen() {
        navigate(Screen.EDIT_PROFILE_SCREEN)
    }

    private fun navigateToContactsScreen() {
        navigate(Screen.CONTACTS_SCREEN)
    }

    fun handleNavigateToEditScreen() {
        handleEvent(MainUserEvent.NavigateToEditingUserEvent)
    }

    override fun handleSpecialEvent(event: MainUserEvent) {
        when (event) {
            MainUserEvent.NavigateToEditingUserEvent -> navigateToEditingScreen()
            MainUserEvent.NavigateToContactsScreen -> navigateToContactsScreen()
            else -> {}
        }
    }

    fun requestUserData() {
        handleEvent(MainUserEvent.UserLoading)
    }

    fun handleNavigateToContactsScreen() {
        handleEvent(MainUserEvent.NavigateToContactsScreen)
    }
}