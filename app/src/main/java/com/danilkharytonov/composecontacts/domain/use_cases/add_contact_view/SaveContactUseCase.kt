package com.danilkharytonov.composecontacts.domain.use_cases.add_contact_view

import com.danilkharytonov.composecontacts.domain.repository.SubUserLocalRepository
import com.danilkharytonov.composecontacts.presentation.add_contacts.AddContactEvent
import com.danilkharytonov.composecontacts.presentation.add_contacts.AddContactState
import com.danilkharytonov.composecontacts.presentation.base.UseCase

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