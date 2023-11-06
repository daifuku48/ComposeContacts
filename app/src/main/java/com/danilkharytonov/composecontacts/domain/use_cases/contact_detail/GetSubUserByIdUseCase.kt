package com.danilkharytonov.composecontacts.domain.use_cases.contact_detail

import com.danilkharytonov.composecontacts.domain.repository.SubUserLocalRepository
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.contact_detail.ContactDetailEvent
import com.danilkharytonov.composecontacts.presentation.contact_detail.ContactDetailState

class GetSubUserByIdUseCase(private val repository: SubUserLocalRepository) :
    UseCase<ContactDetailState, ContactDetailEvent> {
    override suspend fun execute(
        state: ContactDetailState,
        event: ContactDetailEvent
    ): ContactDetailEvent {
        return if (event is ContactDetailEvent.GetContactByIdEvent) {
            ContactDetailEvent.ContactByIdIsReceived(repository.getUserById(event.uuid))
        } else ContactDetailEvent.ErrorEvent
    }

    override fun canHandle(event: ContactDetailEvent): Boolean {
        return event is ContactDetailEvent.GetContactByIdEvent
    }
}