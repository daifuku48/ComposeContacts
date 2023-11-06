package com.danilkharytonov.composecontacts.domain.use_cases.add_contact_view

import com.danilkharytonov.composecontacts.domain.repository.RemoteSubUserRepository
import com.danilkharytonov.composecontacts.presentation.add_contacts.AddContactEvent
import com.danilkharytonov.composecontacts.presentation.add_contacts.AddContactState
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import kotlinx.collections.immutable.toPersistentList

class PagingContactsUseCase(
    private val repository: RemoteSubUserRepository
) : UseCase<AddContactState, AddContactEvent> {
    override suspend fun execute(state: AddContactState, event: AddContactEvent): AddContactEvent {
        return when (event) {
            is AddContactEvent.LoadContactUsersToStart -> {
                val users = (repository.getUsersFromRemote() + state.contactList).toPersistentList()
                AddContactEvent.ContactUsersIsReceived(users)
            }

            is AddContactEvent.LoadContactUsersToEnd -> {
                val users = (state.contactList + repository.getUsersFromRemote()).toPersistentList()
                AddContactEvent.ContactUsersIsReceived(users)
            }

            else -> {
                AddContactEvent.ErrorEvent
            }
        }
    }

    override fun canHandle(event: AddContactEvent): Boolean {
        return event is AddContactEvent.LoadContactUsersToStart || event is AddContactEvent.LoadContactUsersToEnd
    }
}