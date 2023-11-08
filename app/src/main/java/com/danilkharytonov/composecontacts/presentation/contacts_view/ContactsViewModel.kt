package com.danilkharytonov.composecontacts.presentation.contacts_view

import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.domain.model.Screen
import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.use_cases.contacts_view.ContactsEvent
import com.danilkharytonov.domain.use_cases.contacts_view.ContactsState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ContactsViewModel(
    reducer: ContactsReducer,
    useCases: List<com.danilkharytonov.core.base.UseCase<ContactsState, ContactsEvent>>,
    appNavigator: Navigator
) : BaseViewModel<ContactsEvent, ContactsState, ContactsUiState>(reducer, useCases, appNavigator) {

    override val state: Flow<ContactsUiState> = uiState.map { state ->
        reducer.mapToUiModel(state)
    }

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