package com.danilkharytonov.composecontacts.presentation.main_user_view

import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.domain.model.Screen
import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.domain.use_cases.main_user_view.MainUserEvent
import com.danilkharytonov.domain.use_cases.main_user_view.MainUserState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainUserViewModel(
    reducer: MainUserReducer,
    useCases: List<UseCase<MainUserState, MainUserEvent>>,
    appNavigator: Navigator,
) : BaseViewModel<MainUserEvent, MainUserState, MainUserUiState>(reducer, useCases, appNavigator) {

    override val state: Flow<MainUserUiState> = uiState.map { state ->
        reducer.mapToUiModel(state)
    }

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