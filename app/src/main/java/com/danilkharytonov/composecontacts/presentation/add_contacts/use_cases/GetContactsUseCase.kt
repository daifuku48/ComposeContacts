package com.danilkharytonov.composecontacts.presentation.add_contacts.use_cases

import com.danilkharytonov.composecontacts.presentation.add_contacts.AddContactEvent
import com.danilkharytonov.composecontacts.presentation.add_contacts.AddContactState
import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.domain.repository.RemoteSubUserRepository
import kotlinx.collections.immutable.toPersistentList

class GetContactsUseCase(
    private val repository: RemoteSubUserRepository
) : UseCase<AddContactState, AddContactEvent> {
    override suspend fun execute(state: AddContactState, event: AddContactEvent): AddContactEvent {
        return if (event is AddContactEvent.GetContactUsers) {
            try {
                val users = repository.getUsersFromRemote().toPersistentList()
                AddContactEvent.ContactUsersIsReceived(users)
            } catch (e: Exception) {
                AddContactEvent.ErrorEvent
            }
        } else AddContactEvent.ErrorEvent
    }

    override fun canHandle(event: AddContactEvent): Boolean {
        return event is AddContactEvent.GetContactUsers
    }
}