package com.danilkharytonov.composecontacts.presentation.create_user_view

import androidx.navigation.NavOptions
import com.danilkharytonov.core.base.BaseViewModel
import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.core.base.navigation.Navigator
import com.danilkharytonov.core.base.navigation.Screen

class CreateUserViewModel(
    reducer: CreateUserReducer,
    useCases: List<UseCase<CreateUserState, CreateUserEvent>>,
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