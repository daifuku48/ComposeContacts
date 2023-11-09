package com.danilkharytonov.composecontacts.presentation.create_user_view

import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.danilkharytonov.composecontacts.presentation.add_contacts.AddContactUiState
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.domain.model.Screen
import com.danilkharytonov.domain.use_cases.create_user_view.CreateUserEvent
import com.danilkharytonov.domain.use_cases.create_user_view.CreateUserState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CreateUserViewModel(
    reducer: CreateUserReducer,
    useCases: List<com.danilkharytonov.core.base.UseCase<CreateUserState, CreateUserEvent>>,
    appNavigator: Navigator,
) : BaseViewModel<CreateUserEvent, CreateUserState, CreateUserUiState>(
    reducer,
    useCases,
    appNavigator
) {

    override val state: StateFlow<CreateUserUiState> = uiState.map { state ->
        reducer.mapToUiModel(state)
    }.stateIn(viewModelScope, SharingStarted.Lazily, CreateUserUiState())

    init {
        addSpecialEvent(CreateUserEvent.UserSaved)
    }

    override fun createInitialState(): CreateUserState {
        return CreateUserState()
    }

    override fun handleSpecialEvent(event: CreateUserEvent) {
        when (event) {
            CreateUserEvent.UserSaved -> navigateToMainUserScreen()
            else -> {}
        }
    }

    private fun navigateToMainUserScreen() {
        val navOptions = NavOptions.Builder().setPopUpTo(Screen.CREATE_USER_SCREEN, false).build()
        navigate(Screen.MAIN_USER_SCREEN, navOptions)
    }

    fun saveUser() {
        handleEvent(CreateUserEvent.SaveUserEvent)
    }

    fun updateName(name: String) {
        handleEvent(CreateUserEvent.NameChangedEvent(name))
    }

    fun updateSurname(surname: String) {
        handleEvent(CreateUserEvent.SurnameChangedEvent(surname))
    }

    fun updatePhone(phoneNumber: String) {
        handleEvent(CreateUserEvent.PhoneChangedEvent(phoneNumber))
    }

    fun updateEmail(email: String) {
        handleEvent(CreateUserEvent.EmailChangedEvent(email))
    }

    fun updateDateOfBirth(dateOfBirth: String) {
        handleEvent(CreateUserEvent.DateOfBirthChangedEvent(dateOfBirth))
    }

    fun updateIcon(icon: String) {
        handleEvent(CreateUserEvent.IconChangedEvent(icon))
    }
}