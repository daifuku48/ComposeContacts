package com.danilkharytonov.composecontacts.presentation.edit_profile_screen

import com.danilkharytonov.composecontacts.domain.use_cases.edit_profile.EditProfileUseCase
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import java.util.Date

class EditProfileViewModel(
    reducer: EditProfileReducer,
    useCases: List<EditProfileUseCase>,
    appNavigator: Navigator
) : BaseViewModel<EditProfileEvent, EditProfileState>(reducer, useCases, appNavigator) {
    override fun createInitialState(): EditProfileState {
        return EditProfileState()
    }

    fun updateIconEventHandle(image: String){
        handleEvent(EditProfileEvent.EditIconEvent(image))
    }

    override fun handleSpecialEvent(event: EditProfileEvent) {}

    fun updateNameEventHandle(name: String) {
        handleEvent(EditProfileEvent.EditNameEvent(name))
    }

    fun updateSurnameEventHandle(surname: String) {
        handleEvent(EditProfileEvent.EditSurnameEvent(surname))
    }

    fun updatePhoneEventNumber(phoneNumber: String) {
        handleEvent(EditProfileEvent.EditPhoneEvent(phoneNumber))
    }

    fun updateEmailEventHandle(email: String) {
        handleEvent(EditProfileEvent.EditEmailEvent(email))
    }

    fun updateDateOfBirthHandle(date: String) {
        handleEvent(EditProfileEvent.EditBirthEvent(date))
    }

    fun handleEditUser() {
        handleEvent(EditProfileEvent.SaveEditingUser)
    }
}