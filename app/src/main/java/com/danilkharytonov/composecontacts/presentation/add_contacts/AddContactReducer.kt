package com.danilkharytonov.composecontacts.presentation.add_contacts

import com.danilkharytonov.composecontacts.presentation.uimodel.toUi
import com.danilkharytonov.core.base.Reducer
import com.danilkharytonov.domain.use_cases.add_contacts_view.AddContactEvent
import com.danilkharytonov.domain.use_cases.add_contacts_view.AddContactState
import kotlinx.collections.immutable.toPersistentList

class AddContactReducer : Reducer<AddContactState, AddContactEvent, AddContactUiState> {
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

    override fun mapToUiModel(state: AddContactState): AddContactUiState {
        return AddContactUiState(
            contactList = state.contactList.map { contactUser ->
                contactUser.toUi()
            }.toPersistentList(),
            savedUser = state.savedUser?.toUi(),
            isExpanded = state.isExpanded,
            currentCategoryText = state.currentCategoryText,
            currentCategory = state.currentCategory.toUi(),
            isPopupAddContactVisible = state.isPopupAddContactVisible
        )
    }
}