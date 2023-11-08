package com.danilkharytonov.composecontacts.presentation.contact_detail_view

import com.danilkharytonov.core.base.Reducer
import com.danilkharytonov.domain.use_cases.contact_detail_view.ContactDetailEvent
import com.danilkharytonov.domain.use_cases.contact_detail_view.ContactDetailState

class ContactDetailReducer : Reducer<ContactDetailState, ContactDetailEvent, ContactDetailUiState> {
    override fun reduce(state: ContactDetailState, event: ContactDetailEvent): ContactDetailState {
        return when (event) {
            is ContactDetailEvent.ContactByIdIsReceived -> state.copy(
                uuid = event.user.uuid,
                name = event.user.name,
                surname = event.user.surname,
                email = event.user.email,
                iconImage = event.user.iconImage,
                phoneNumber = event.user.phoneNumber,
                dateOfBirth = event.user.dateOfBirth,
                category = event.user.category
            )

            is ContactDetailEvent.DeleteUserEvent -> state
            is ContactDetailEvent.GetContactByIdEvent -> state
            is ContactDetailEvent.UserIsDeletedEvent -> state
            is ContactDetailEvent.ErrorEvent -> state
            is ContactDetailEvent.HideDeleteUserPopUpEvent -> state.copy(isVisiblePopUpDeleteDialog = false)
            is ContactDetailEvent.ShowDeleteUserPopUpEvent -> state.copy(isVisiblePopUpDeleteDialog = true)
        }
    }

    override fun mapToUiModel(state: ContactDetailState): ContactDetailUiState {
        return ContactDetailUiState(
            uuid = state.uuid,
            name = state.name,
            surname = state.surname,
            email = state.email,
            phoneNumber = state.phoneNumber,
            dateOfBirth = state.dateOfBirth,
            iconImage = state.iconImage,
            category = state.category,
            isVisiblePopUpDeleteDialog = state.isVisiblePopUpDeleteDialog
        )
    }
}