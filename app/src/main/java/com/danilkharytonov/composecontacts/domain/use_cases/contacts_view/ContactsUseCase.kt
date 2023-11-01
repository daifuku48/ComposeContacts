package com.danilkharytonov.composecontacts.domain.use_cases.contacts_view

import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsEvent
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsState

class ContactsUseCase : UseCase<ContactsState, ContactsEvent> {
    override suspend fun execute(state: ContactsState, event: ContactsEvent): ContactsEvent {
        TODO("Not yet implemented")
    }

    override fun canHandle(event: ContactsEvent): Boolean {
        TODO("Not yet implemented")
    }
}