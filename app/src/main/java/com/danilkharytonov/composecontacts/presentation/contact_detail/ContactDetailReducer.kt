package com.danilkharytonov.composecontacts.presentation.contact_detail

import com.danilkharytonov.composecontacts.presentation.base.Reducer

class ContactDetailReducer : Reducer<ContactDetailState, ContactDetailEvent> {
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
        }
    }
}