package com.danilkharytonov.composecontacts.domain.use_cases.contacts_view

import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsEvent
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsState
import kotlinx.collections.immutable.toPersistentList

class SearchContactsUseCase : UseCase<ContactsState, ContactsEvent> {
    override suspend fun execute(state: ContactsState, event: ContactsEvent): ContactsEvent {
        return if (event is ContactsEvent.SearchTextChangedEvent) {
            val searchText = event.searchText
            val filteredContacts = state.contactsList.filter { contact ->
                contact.name.contains(searchText, ignoreCase = true) ||
                        contact.surname.contains(searchText, ignoreCase = true)
            }.toPersistentList()
            ContactsEvent.ContactsIsFiltered(contacts = filteredContacts)
        } else ContactsEvent.ErrorEvent
    }

    override fun canHandle(event: ContactsEvent): Boolean {
        return false
    }
}