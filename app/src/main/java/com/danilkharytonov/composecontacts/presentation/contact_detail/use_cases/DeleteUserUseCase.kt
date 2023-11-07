package com.danilkharytonov.composecontacts.presentation.contact_detail.use_cases

import com.danilkharytonov.composecontacts.presentation.contact_detail.ContactDetailEvent
import com.danilkharytonov.composecontacts.presentation.contact_detail.ContactDetailState
import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.domain.repository.SubUserLocalRepository

class DeleteUserUseCase(private val repository: SubUserLocalRepository) :
    UseCase<ContactDetailState, ContactDetailEvent> {
    override suspend fun execute(
        state: ContactDetailState,
        event: ContactDetailEvent
    ): ContactDetailEvent {
        return if (event is ContactDetailEvent.DeleteUserEvent) {
            repository.deleteUserById(event.uuid)
            ContactDetailEvent.UserIsDeletedEvent
        } else ContactDetailEvent.ErrorEvent
    }

    override fun canHandle(event: ContactDetailEvent): Boolean {
        return event is ContactDetailEvent.DeleteUserEvent
    }
}