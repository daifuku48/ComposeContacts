package com.danilkharytonov.composecontacts.presentation.contacts_view

import com.danilkharytonov.composecontacts.presentation.base.Reducer

class ContactsReducer : Reducer<ContactsState, ContactsEvent> {
    override fun reduce(state: ContactsState, event: ContactsEvent): ContactsState {
        return when (event) {
            is ContactsEvent.CategoryOnChangedEvent -> state.copy(
                currentCategory = event.category,
                currentCategoryText = event.categoryText
            )

            is ContactsEvent.ContactsIsFiltered -> state.copy(contactsList = event.contacts)
            is ContactsEvent.ExpandedChangedEvent -> state.copy(isExpanded = event.isExpanded)
            is ContactsEvent.FilterContactsEvent -> state
            is ContactsEvent.GetContactsEvent -> state
            is ContactsEvent.SearchTextChangedEvent -> state.copy(searchText = event.searchText)
            is ContactsEvent.ErrorEvent -> state
        }
    }
}