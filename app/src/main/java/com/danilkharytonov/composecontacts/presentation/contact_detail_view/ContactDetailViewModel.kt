package com.danilkharytonov.composecontacts.presentation.contact_detail_view

import androidx.lifecycle.viewModelScope
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.domain.use_cases.contact_detail_view.ContactDetailEvent
import com.danilkharytonov.domain.use_cases.contact_detail_view.ContactDetailState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ContactDetailViewModel(
    reducer: ContactDetailReducer,
    useCases: List<UseCase<ContactDetailState, ContactDetailEvent>>,
    appNavigator: Navigator,
) : BaseViewModel<ContactDetailEvent, ContactDetailState, ContactDetailUiState>(
    reducer,
    useCases,
    appNavigator
) {

    override val state: StateFlow<ContactDetailUiState> = uiState.map { state ->
        reducer.mapToUiModel(state)
    }.stateIn(viewModelScope, SharingStarted.Lazily, ContactDetailUiState())

    init {
        addSpecialEvent(ContactDetailEvent.UserIsDeletedEvent)
    }

    override fun createInitialState(): ContactDetailState {
        return ContactDetailState()
    }

    fun loadUser(uuid: String) {
        handleEvent(ContactDetailEvent.GetContactByIdEvent(uuid))
    }

    override fun handleSpecialEvent(event: ContactDetailEvent) {
        when (event) {
            is ContactDetailEvent.UserIsDeletedEvent -> {
                navigateToContactList()
            }

            else -> {}
        }
    }

    private fun navigateToContactList() {
        popBackStack()
    }

    fun deleteUser(uuid: String) {
        handleEvent(ContactDetailEvent.DeleteUserEvent(uuid))
    }

    fun hidePopUpDeleteContact() {
        handleEvent(ContactDetailEvent.HideDeleteUserPopUpEvent)
    }

    fun showPopUpToDeleteContact() {
        handleEvent(ContactDetailEvent.ShowDeleteUserPopUpEvent)
    }
}