package com.danilkharytonov.composecontacts.domain.use_cases.contacts_view

import com.danilkharytonov.composecontacts.domain.model.Category
import com.danilkharytonov.composecontacts.domain.repository.SubUserRepository
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsEvent
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsState

class FilterContactsUseCase(private val repository: SubUserRepository) :
    UseCase<ContactsState, ContactsEvent> {
    override suspend fun execute(state: ContactsState, event: ContactsEvent): ContactsEvent {
        return if (event is ContactsEvent.FilterContactsEvent) {
            when (event.category) {
                Category.ALL -> ContactsEvent.ContactsIsFiltered(repository.getAllUsers())
                Category.FAMILY -> ContactsEvent.ContactsIsFiltered(
                    repository.getUsersByCategory(
                        event.category
                    )
                )

                Category.FRIENDS -> ContactsEvent.ContactsIsFiltered(
                    repository.getUsersByCategory(
                        event.category
                    )
                )

                Category.WORK -> ContactsEvent.ContactsIsFiltered(
                    repository.getUsersByCategory(
                        event.category
                    )
                )
            }
            ContactsEvent.ErrorEvent
        } else ContactsEvent.ErrorEvent
    }

    override fun canHandle(event: ContactsEvent): Boolean {
        return event is ContactsEvent.FilterContactsEvent
    }
}