package com.danilkharytonov.composecontacts.presentation.contact_detail

import androidx.navigation.NavOptions
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.Screen
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator

class ContactDetailViewModel(
    reducer: ContactDetailReducer,
    useCases: List<UseCase<ContactDetailState, ContactDetailEvent>>,
    appNavigator: Navigator
) : BaseViewModel<ContactDetailEvent, ContactDetailState>(reducer, useCases, appNavigator) {

    init {
        addSpecialEvent(ContactDetailEvent.UserIsDeletedEvent)
    }

    override fun createInitialState(): ContactDetailState {
        return ContactDetailState()
    }

    fun loadUser(uuid: String) {
        handleEvent(ContactDetailEvent.GetContactByIdEvent(uuid))
    }

    override fun handleSpecialEvent(event: ContactDetailEvent) {
        when (event) {
            is ContactDetailEvent.UserIsDeletedEvent -> {
                navigateToContactList()
            }

            else -> {}
        }
    }

    private fun navigateToContactList() {
        val navOptions =
            NavOptions.Builder().setPopUpTo(Screen.ContactDetailScreen.route, true).build()
        navigate(Screen.ContactsScreen.route, navOptions)
    }

    fun deleteUser(uuid: String) {
        handleEvent(ContactDetailEvent.DeleteUserEvent(uuid))
    }
}