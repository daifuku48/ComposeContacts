package com.danilkharytonov.composecontacts.presentation.contacts_view

import com.danilkharytonov.composecontacts.data.model.ContactUser
import com.danilkharytonov.composecontacts.domain.model.Category
import com.danilkharytonov.composecontacts.presentation.base.navigation.UiEvent
import kotlinx.collections.immutable.PersistentList

sealed class ContactsEvent : UiEvent {
    object GetContactsEvent : ContactsEvent()
    data class SearchTextChangedEvent(val searchText: String) : ContactsEvent()
    data class CategoryOnChangedEvent(val category: Category, val categoryText: String) :
        ContactsEvent()

    data class ContactsIsFiltered(val contacts: PersistentList<ContactUser>) : ContactsEvent()
    data class FilterContactsEvent(val searchText: String, val category: Category) : ContactsEvent()
    data class ExpandedChangedEvent(val isExpanded: Boolean) : ContactsEvent()
    object ErrorEvent : ContactsEvent()
}