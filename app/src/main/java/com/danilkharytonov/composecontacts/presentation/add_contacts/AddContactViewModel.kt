package com.danilkharytonov.composecontacts.presentation.add_contacts

import androidx.navigation.NavOptions
import com.danilkharytonov.core.base.BaseViewModel
import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.core.base.navigation.Navigator
import com.danilkharytonov.core.base.navigation.Screen
import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.model.ContactUser

class AddContactViewModel(
    reducer: AddContactReducer,
    useCases: List<UseCase<AddContactState, AddContactEvent>>,
    appNavigator: Navigator
) : BaseViewModel<AddContactEvent, AddContactState>(reducer, useCases, appNavigator) {
    override fun createInitialState(): AddContactState {
        return AddContactState()
    }

    override fun handleSpecialEvent(event: AddContactEvent) {}

    fun loadUserToEnd() {
        handleEvent(AddContactEvent.LoadContactUsersToEnd)
    }

    fun saveUser() {
        handleEvent(AddContactEvent.SaveContactUserEvent)
    }

    fun showPopUpAddContact() {
        handleEvent(AddContactEvent.ShowPopUpAddContact)
    }

    fun hidePopUpAddContact() {
        handleEvent(AddContactEvent.HidePopUpAddContact)
    }

    fun setSavedUser(contactUser: ContactUser) {
        handleEvent(AddContactEvent.SetUserForSave(contactUser))
    }

    fun setCategory(category: Category) {
        handleEvent(AddContactEvent.SetCategoryForSavedUser(category = category))
    }

    fun declineSavedUser() {
        handleEvent(AddContactEvent.ClearUserForSave)
    }

    fun loadUsers() {
        handleEvent(AddContactEvent.GetContactUsers)
    }

    fun navigateToContactScreen() {
        val navOptions = NavOptions.Builder().setPopUpTo(Screen.ADD_CONTACT_SCREEN, true).build()
        navigate(Screen.CONTACTS_SCREEN, navOptions)
    }

    fun expandMenu() {
        handleEvent(AddContactEvent.ExpandedChangedEvent(isExpanded = !uiState.value.isExpanded))
    }
}