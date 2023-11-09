package com.danilkharytonov.domain.use_cases.contacts_view

import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.repository.SubUserLocalRepository

class FilterContactsUseCase(
    private val repository: SubUserLocalRepository
) : UseCase<ContactsState, ContactsEvent> {
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