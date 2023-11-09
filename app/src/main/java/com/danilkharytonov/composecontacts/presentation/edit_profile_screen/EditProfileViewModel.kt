package com.danilkharytonov.composecontacts.presentation.edit_profile_screen

import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.danilkharytonov.composecontacts.presentation.add_contacts.AddContactUiState
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.domain.model.Screen
import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.domain.use_cases.edit_profile_view.EditProfileEvent
import com.danilkharytonov.domain.use_cases.edit_profile_view.EditProfileState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class EditProfileViewModel(
    reducer: EditProfileReducer,
    useCases: List<UseCase<EditProfileState, EditProfileEvent>>,
    appNavigator: Navigator,
) : BaseViewModel<EditProfileEvent, EditProfileState, EditProfileUiState>(reducer, useCases, appNavigator) {

    override val state: StateFlow<EditProfileUiState> = uiState.map {state ->
        reducer.mapToUiModel(state)
    }.stateIn(viewModelScope, SharingStarted.Lazily, EditProfileUiState())

    init {
        addSpecialEvent(EditProfileEvent.EditingUserSavedEvent)
        handleEvent(EditProfileEvent.GetMainUserEvent)
    }

    override fun createInitialState(): EditProfileState {
        return EditProfileState()
    }

    fun updateIcon(image: String) {
        handleEvent(EditProfileEvent.EditIconEvent(image))
    }

    override fun handleSpecialEvent(event: EditProfileEvent) {
        when (event) {
            EditProfileEvent.EditingUserSavedEvent -> {
                navigateToMainScreen()
            }

            else -> {}
        }
    }

    private fun navigateToMainScreen() {
        val navOptions = NavOptions.Builder().setPopUpTo(Screen.MAIN_USER_SCREEN, true).build()
        navigate(Screen.MAIN_USER_SCREEN, navOptions)
    }

    fun updateName(name: String) {
        handleEvent(EditProfileEvent.EditNameEvent(name))
    }

    fun updateSurname(surname: String) {
        handleEvent(EditProfileEvent.EditSurnameEvent(surname))
    }

    fun updatePhone(phoneNumber: String) {
        handleEvent(EditProfileEvent.EditPhoneEvent(phoneNumber))
    }

    fun updateEmail(email: String) {
        handleEvent(EditProfileEvent.EditEmailEvent(email))
    }

    fun updateDateOfBirth(date: String) {
        handleEvent(EditProfileEvent.EditBirthEvent(date))
    }

    fun editUser() {
        handleEvent(EditProfileEvent.SaveEditingUser)
    }
}