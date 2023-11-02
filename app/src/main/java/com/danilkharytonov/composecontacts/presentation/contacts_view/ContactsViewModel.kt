package com.danilkharytonov.composecontacts.presentation.contacts_view

import com.danilkharytonov.composecontacts.domain.model.Category
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator

class ContactsViewModel(
    reducer: ContactsReducer,
    useCases: List<UseCase<ContactsState, ContactsEvent>>,
    appNavigator: Navigator
) : BaseViewModel<ContactsEvent, ContactsState>(reducer, useCases, appNavigator) {
    init {
        handleEvent(ContactsEvent.GetContactsEvent)
    }

    override fun createInitialState(): ContactsState {
        return ContactsState()
    }

    fun handleChangedSearchText(newText: String) {
        handleEvent(ContactsEvent.SearchTextChangedEvent(newText))
        handleEvent(
            ContactsEvent.FilterContactsEvent(
                searchText = uiState.value.searchText,
                category = uiState.value.currentCategory
            )
        )
    }

    fun handleChangedCategory(category: Category, categoryText: String) {
        handleEvent(ContactsEvent.CategoryOnChangedEvent(category, categoryText))
    }

    fun handleExpandMenu() {
        handleEvent(ContactsEvent.ExpandedChangedEvent(isExpanded = !uiState.value.isExpanded))
    }

    override fun handleSpecialEvent(event: ContactsEvent) {}
}