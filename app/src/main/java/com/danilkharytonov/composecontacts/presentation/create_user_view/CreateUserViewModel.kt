package com.danilkharytonov.composecontacts.presentation.create_user_view

import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.danilkharytonov.composecontacts.domain.use_cases.create_user_view.SaveMainUserUseCase
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.Screen
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import kotlinx.coroutines.launch

class CreateUserViewModel(
    reducer: CreateUserReducer,
    useCases: List<SaveMainUserUseCase>,
    appNavigator: Navigator
) : BaseViewModel<CreateUserEvent, CreateUserState>(reducer, useCases, appNavigator) {
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
        viewModelScope.launch {
            val navOptions = NavOptions.Builder().setPopUpTo(Screen.CREATE_USER_SCREEN, false).build()
            navigate(Screen.MAIN_USER_SCREEN, navOptions)
        }
    }

    fun handleSaveUser() {
        handleEvent(CreateUserEvent.SaveUserEvent)
    }

    fun updateNameEventHandle(name: String) {
        handleEvent(CreateUserEvent.NameChangedEvent(name))
    }

    fun updateSurnameEventHandle(surname: String) {
        handleEvent(CreateUserEvent.SurnameChangedEvent(surname))
    }

    fun updatePhoneEventNumber(phoneNumber: String) {
        handleEvent(CreateUserEvent.PhoneChangedEvent(phoneNumber))
    }

    fun updateEmailEventHandle(email: String) {
        handleEvent(CreateUserEvent.EmailChangedEvent(email))
    }

    fun updateDateOfBirthHandle(dateOfBirth: String) {
        handleEvent(CreateUserEvent.DateOfBirthChangedEvent(dateOfBirth))
    }

    fun updateIconEventHandle(icon: String) {
        handleEvent(CreateUserEvent.IconChangedEvent(icon))
    }
}