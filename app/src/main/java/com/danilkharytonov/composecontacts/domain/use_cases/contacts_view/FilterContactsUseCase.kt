package com.danilkharytonov.composecontacts.domain.use_cases.contacts_view

import com.danilkharytonov.composecontacts.domain.model.Category
import com.danilkharytonov.composecontacts.domain.repository.SubUserRepository
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsEvent
import com.danilkharytonov.composecontacts.presentation.contacts_view.ContactsState

class FilterContactsUseCase(private val repository: SubUserRepository) :
    UseCase<ContactsState, ContactsEvent> {
    override suspend fun execute(state: ContactsState, event: ContactsEvent): ContactsEvent {
        return when (event) {
            is ContactsEvent.FilterContactsEvent -> {
                when (event.category) {
                    Category.ALL -> ContactsEvent.ContactsIsFiltered(repository.getAllUsers())
                    else -> ContactsEvent.ContactsIsFiltered(
                        repository.getUsersByCategory(
                            event.category
                        )
                    )
                }
            }
            is ContactsEvent.GetContactsEvent -> {
                ContactsEvent.ContactsIsFiltered(repository.getAllUsers())
            }
            else -> ContactsEvent.ErrorEvent
        }
    }

    override fun canHandle(event: ContactsEvent): Boolean {
        return event is ContactsEvent.FilterContactsEvent || event is ContactsEvent.GetContactsEvent
    }
}