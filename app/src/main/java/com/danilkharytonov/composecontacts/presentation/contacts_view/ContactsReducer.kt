package com.danilkharytonov.composecontacts.presentation.contacts_view

import com.danilkharytonov.core.base.Reducer
import com.danilkharytonov.domain.use_cases.contacts_view.ContactsEvent
import com.danilkharytonov.domain.use_cases.contacts_view.ContactsState
import kotlinx.collections.immutable.toPersistentList
import okhttp3.internal.toImmutableList

class ContactsReducer : Reducer<ContactsState, ContactsEvent, ContactsUiState> {
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

    override fun mapToUiModel(state: ContactsState): ContactsUiState {
        return ContactsUiState(
            searchText = state.searchText,
            currentCategoryText = state.currentCategoryText,
            currentCategory = state.currentCategory.toUi(),
            contactsList = state.contactsList.map { category -> category.toUi() }.toPersistentList(),
            isExpanded = state.isExpanded
        )
    }
}