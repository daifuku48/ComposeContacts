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
    }

    override fun createInitialState(): MainUserState {
        return MainUserState()
    }

    private fun navigateToEditingScreen() {
        navigate(Screen.EDIT_PROFILE_SCREEN)
    }

    fun handleNavigateToEditScreen() {
        handleEvent(MainUserEvent.NavigateToEditingUserEvent)
    }

    override fun handleSpecialEvent(event: MainUserEvent) {
        when (event) {
            MainUserEvent.NavigateToEditingUserEvent -> navigateToEditingScreen()
            else -> {}
        }
    }

    fun updateState() {
        handleEvent(MainUserEvent.UserLoading)
    }
}