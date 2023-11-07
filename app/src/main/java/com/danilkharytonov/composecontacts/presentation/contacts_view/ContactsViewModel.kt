package com.danilkharytonov.composecontacts.presentation.contacts_view

import com.danilkharytonov.core.base.BaseViewModel
import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.core.base.navigation.Navigator
import com.danilkharytonov.core.base.navigation.Screen
import com.danilkharytonov.domain.model.Category

class ContactsViewModel(
    reducer: ContactsReducer,
    useCases: List<UseCase<ContactsState, ContactsEvent>>,
    appNavigator: Navigator
) : BaseViewModel<ContactsEvent, ContactsState>(reducer, useCases, appNavigator) {
    fun getContactEvent() {
        handleEvent(ContactsEvent.GetContactsEvent)
    }

    override fun createInitialState(): ContactsState {
        return ContactsState()
    }

    fun changedSearchText(newText: String) {
        handleEvent(ContactsEvent.SearchTextChangedEvent(newText))
        handleEvent(
            ContactsEvent.FilterContactsEvent(
                searchText = uiState.value.searchText,
                category = uiState.value.currentCategory
            )
        )
    }

    fun changedCategory(category: Category, categoryText: String) {
        handleEvent(ContactsEvent.CategoryOnChangedEvent(category, categoryText))
        handleEvent(
            ContactsEvent.FilterContactsEvent(
                searchText = uiState.value.searchText,
                category = uiState.value.currentCategory
            )
        )
    }

    fun navigateToAddContact() {
        navigate(Screen.AddContactScreen.route)
    }

    fun navigateToDetailContact(uuid: String) {
        navigate("${Screen.ContactDetailScreen.route}/$uuid")
    }

    fun expandMenu() {
        handleEvent(ContactsEvent.ExpandedChangedEvent(isExpanded = !uiState.value.isExpanded))
    }

    override fun handleSpecialEvent(event: ContactsEvent) {}
}