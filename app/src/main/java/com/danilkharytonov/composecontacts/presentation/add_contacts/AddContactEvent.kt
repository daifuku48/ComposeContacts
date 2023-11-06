package com.danilkharytonov.composecontacts.presentation.add_contacts

import com.danilkharytonov.composecontacts.data.model.ContactUser
import com.danilkharytonov.composecontacts.domain.model.Category
import com.danilkharytonov.composecontacts.presentation.base.navigation.UiEvent
import kotlinx.collections.immutable.PersistentList

sealed class AddContactEvent : UiEvent {
    object GetContactUsers : AddContactEvent()
    data class ContactUsersIsReceived(val contacts: PersistentList<ContactUser>) : AddContactEvent()
    object SaveContactUserEvent : AddContactEvent()

    object LoadContactUsersToEnd : AddContactEvent()
    object LoadContactUsersToStart : AddContactEvent()
    data class SetUserForSave(val user: ContactUser) : AddContactEvent()
    object ClearUserForSave : AddContactEvent()
    data class SetCategoryForSavedUser(val category: Category) : AddContactEvent()
    object ContactUserIsSaved : AddContactEvent()
    data class ExpandedChangedEvent(val isExpanded: Boolean) : AddContactEvent()

    object ShowPopUpAddContact : AddContactEvent()
    object HidePopUpAddContact : AddContactEvent()
    object ErrorEvent : AddContactEvent()
}