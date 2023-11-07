package com.danilkharytonov.domain.use_cases.contacts_view

import com.danilkharytonov.core.base.UiEvent
import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.model.ContactUser
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