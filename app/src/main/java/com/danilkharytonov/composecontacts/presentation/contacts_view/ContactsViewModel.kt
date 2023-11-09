package com.danilkharytonov.composecontacts.presentation.contacts_view

import androidx.lifecycle.viewModelScope
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.model.Screen
import com.danilkharytonov.domain.use_cases.contacts_view.ContactsEvent
import com.danilkharytonov.domain.use_cases.contacts_view.ContactsState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ContactsViewModel(
    reducer: ContactsReducer,
    useCases: List<com.danilkharytonov.core.base.UseCase<ContactsState, ContactsEvent>>,
    appNavigator: Navigator
) : BaseViewModel<ContactsEvent, ContactsState, ContactsUiState>(reducer, useCases, appNavigator) {

    override val state: StateFlow<ContactsUiState> = uiState.map { state ->
        reducer.mapToUiModel(state)
    }.stateIn(viewModelScope, SharingStarted.Lazily, ContactsUiState())

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

    fun changedCategory(category: UiCategory, categoryText: String) {
        handleEvent(ContactsEvent.CategoryOnChangedEvent(category.toDomain(), categoryText))
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