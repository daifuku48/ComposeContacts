package com.danilkharytonov.domain.use_cases.contact_detail_view

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