package com.danilkharytonov.composecontacts.presentation.add_contacts

import androidx.navigation.NavOptions
import com.danilkharytonov.composecontacts.data.model.ContactUser
import com.danilkharytonov.composecontacts.domain.model.Category
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.Screen
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator

class AddContactViewModel(
    reducer: AddContactReducer,
    useCases: List<UseCase<AddContactState, AddContactEvent>>,
    appNavigator: Navigator
) : BaseViewModel<AddContactEvent, AddContactState>(reducer, useCases, appNavigator) {
    init {
        addSpecialEvent(AddContactEvent.NavigateToContactList)
    }

    override fun createInitialState(): AddContactState {
        return AddContactState()
    }

    fun handleLoadUserToEndEvent() {
        handleEvent(AddContactEvent.LoadContactUsersToEnd)
    }

    fun handleSavedUser() {
        handleEvent(AddContactEvent.SaveContactUserEvent)
    }

    fun handleSetSavedUser(contactUser: ContactUser) {
        handleEvent(AddContactEvent.SetUserForSave(contactUser))
    }

    fun handleSetCategory(category: Category) {
        handleEvent(AddContactEvent.SetCategoryForSavedUser(category = category))
    }

    fun declineSavedUser() {
        handleEvent(AddContactEvent.ClearUserForSave)
    }

    fun handleLoadUserEvent() {
        handleEvent(AddContactEvent.GetContactUsers)
    }

    override fun handleSpecialEvent(event: AddContactEvent) {
        when (event) {
            is AddContactEvent.NavigateToContactList -> {
                navigateToContactScreen()
            }

            else -> {}
        }
    }

    private fun navigateToContactScreen() {
        val navOptions = NavOptions.Builder().setPopUpTo(Screen.ADD_CONTACT_SCREEN, true).build()
        navigate(Screen.CONTACTS_SCREEN, navOptions)
    }

    fun handleExpandMenu() {
        handleEvent(AddContactEvent.ExpandedChangedEvent(isExpanded = !uiState.value.isExpanded))
    }

    fun handleNavigateToContactList() {
        handleEvent(AddContactEvent.NavigateToContactList)
    }
}