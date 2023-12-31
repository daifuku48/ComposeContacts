package com.danilkharytonov.composecontacts.presentation.add_contacts

import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.composecontacts.presentation.uimodel.UiCategory
import com.danilkharytonov.composecontacts.presentation.uimodel.UiContactUser
import com.danilkharytonov.composecontacts.presentation.uimodel.toDomain
import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.domain.model.Screen
import com.danilkharytonov.domain.use_cases.add_contacts_view.AddContactEvent
import com.danilkharytonov.domain.use_cases.add_contacts_view.AddContactState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class AddContactViewModel(
    reducer: AddContactReducer,
    useCases: List<UseCase<AddContactState, AddContactEvent>>,
    appNavigator: Navigator,
) : BaseViewModel<AddContactEvent, AddContactState, AddContactUiState>(
    reducer,
    useCases,
    appNavigator
) {

    override val state: StateFlow<AddContactUiState> = uiState.map { state ->
        reducer.mapToUiModel(state)
    }.stateIn(viewModelScope, SharingStarted.Lazily, AddContactUiState())

    override fun createInitialState(): AddContactState {
        return AddContactState()
    }

    override fun handleSpecialEvent(event: AddContactEvent) {}

    fun loadUserToEnd() {
        handleEvent(AddContactEvent.LoadContactUsersToEnd)
    }

    fun saveUser() {
        handleEvent(AddContactEvent.SaveContactUserEvent)
    }

    fun hidePopUpAddContact() {
        handleEvent(AddContactEvent.HidePopUpAddContact)
    }

    fun setSavedUser(contactUser: UiContactUser) {
        handleEvent(AddContactEvent.SetUserForSave(contactUser.toDomain()))
    }

    fun setCategory(category: UiCategory) {
        handleEvent(AddContactEvent.SetCategoryForSavedUser(category = category.toDomain()))
    }

    fun declineSavedUser() {
        handleEvent(AddContactEvent.ClearUserForSave)
    }

    fun loadUsers() {
        handleEvent(AddContactEvent.GetContactUsers)
    }

    fun navigateToContactScreen() {
        val navOptions = NavOptions.Builder().setPopUpTo(Screen.ADD_CONTACT_SCREEN, true).build()
        navigate(Screen.CONTACTS_SCREEN, navOptions)
    }

    fun expandMenu() {
        handleEvent(AddContactEvent.ExpandedChangedEvent(isExpanded = !uiState.value.isExpanded))
    }
}