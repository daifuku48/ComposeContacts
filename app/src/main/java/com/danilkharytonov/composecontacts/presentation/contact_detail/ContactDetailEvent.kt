package com.danilkharytonov.composecontacts.presentation.contact_detail

import com.danilkharytonov.core.base.UiEvent
import com.danilkharytonov.domain.model.ContactUser

sealed class ContactDetailEvent : UiEvent {
    data class GetContactByIdEvent(val uuid: String) : ContactDetailEvent()
    data class ContactByIdIsReceived(val user: ContactUser) : ContactDetailEvent()
    data class DeleteUserEvent(val uuid: String) : ContactDetailEvent()
    object ShowDeleteUserPopUpEvent : ContactDetailEvent()
    object HideDeleteUserPopUpEvent : ContactDetailEvent()
    object UserIsDeletedEvent : ContactDetailEvent()
    object ErrorEvent : ContactDetailEvent()
}