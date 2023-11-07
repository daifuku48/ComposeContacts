package com.danilkharytonov.composecontacts.presentation.contact_detail

import com.danilkharytonov.core.base.BaseViewModel
import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.core.base.navigation.Navigator

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
        popBackStack()
    }

    fun deleteUser(uuid: String) {
        handleEvent(ContactDetailEvent.DeleteUserEvent(uuid))
    }

    fun hidePopUpDeleteContact() {
        handleEvent(ContactDetailEvent.HideDeleteUserPopUpEvent)
    }

    fun showPopUpToDeleteContact() {
        handleEvent(ContactDetailEvent.ShowDeleteUserPopUpEvent)
    }
}