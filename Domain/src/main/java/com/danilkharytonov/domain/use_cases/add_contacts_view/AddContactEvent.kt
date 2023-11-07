package com.danilkharytonov.domain.use_cases.add_contacts_view

import com.danilkharytonov.core.base.UiEvent
import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.model.ContactUser
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