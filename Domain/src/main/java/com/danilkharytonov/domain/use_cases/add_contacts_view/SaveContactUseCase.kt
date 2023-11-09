package com.danilkharytonov.domain.use_cases.add_contacts_view

import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.domain.repository.SubUserLocalRepository

class SaveContactUseCase(private val repository: SubUserLocalRepository) :
    UseCase<AddContactState, AddContactEvent> {
    override suspend fun execute(state: AddContactState, event: AddContactEvent): AddContactEvent {
        return if (event is AddContactEvent.SaveContactUserEvent) {
            if (state.savedUser != null) {
                repository.insertUser(state.savedUser)
                AddContactEvent.ContactUserIsSaved
            }
            AddContactEvent.ErrorEvent
        } else AddContactEvent.ErrorEvent
    }

    override fun canHandle(event: AddContactEvent): Boolean {
        return event is AddContactEvent.SaveContactUserEvent
    }
}