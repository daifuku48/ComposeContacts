package com.danilkharytonov.domain.use_cases.add_contacts_view

import com.danilkharytonov.core.base.Reducer

class AddContactReducer : Reducer<AddContactState, AddContactEvent> {
    override fun reduce(state: AddContactState, event: AddContactEvent): AddContactState {
        return when (event) {
            is AddContactEvent.ContactUsersIsReceived -> state.copy(contactList = event.contacts)
            is AddContactEvent.GetContactUsers -> state
            is AddContactEvent.ErrorEvent -> state
            is AddContactEvent.ContactUserIsSaved -> state
            is AddContactEvent.SaveContactUserEvent -> state
            is AddContactEvent.SetCategoryForSavedUser -> state.copy(
                savedUser = state.savedUser?.copy(
                    category = event.category
                ),
                currentCategoryText = event.category.name.lowercase(),
                currentCategory = event.category
            )

            is AddContactEvent.SetUserForSave -> state.copy(savedUser = event.user)
            is AddContactEvent.LoadContactUsersToEnd -> state
            is AddContactEvent.LoadContactUsersToStart -> state
            is AddContactEvent.ClearUserForSave -> state.copy(savedUser = null)
            is AddContactEvent.ExpandedChangedEvent -> state.copy(isExpanded = event.isExpanded)
            is AddContactEvent.HidePopUpAddContact -> state.copy(isPopupAddContactVisible = false)
            is AddContactEvent.ShowPopUpAddContact -> state.copy(isPopupAddContactVisible = true)
        }
    }
}