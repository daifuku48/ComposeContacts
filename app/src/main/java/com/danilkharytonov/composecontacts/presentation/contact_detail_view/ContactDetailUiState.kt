package com.danilkharytonov.composecontacts.presentation.contact_detail_view

import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.use_cases.contact_detail_view.ContactDetailState

data class ContactDetailUiState(
    val uuid: String? = null,
    val name: String? = null,
    val surname: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val dateOfBirth: String? = null,
    val iconImage: String? = null,
    val category: Category? = null,
    val isVisiblePopUpDeleteDialog: Boolean = false
)

fun ContactDetailState.toUi() : ContactDetailUiState {
    return ContactDetailUiState(
        uuid = uuid,
        name = name,
        surname = surname,
        email = email,
        phoneNumber = phoneNumber,
        dateOfBirth = dateOfBirth,
        iconImage = iconImage,
        category = category,
        isVisiblePopUpDeleteDialog = isVisiblePopUpDeleteDialog
    )
}