package com.danilkharytonov.composecontacts.presentation.edit_profile_screen

import androidx.navigation.NavOptions
import com.danilkharytonov.composecontacts.domain.use_cases.edit_profile.EditProfileUseCase
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.Screen
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator

class EditProfileViewModel(
    reducer: EditProfileReducer, useCases: List<EditProfileUseCase>, appNavigator: Navigator
) : BaseViewModel<EditProfileEvent, EditProfileState>(reducer, useCases, appNavigator) {

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