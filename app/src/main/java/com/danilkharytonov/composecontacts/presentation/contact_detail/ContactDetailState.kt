package com.danilkharytonov.composecontacts.presentation.contact_detail

import com.danilkharytonov.composecontacts.domain.model.Category
import com.danilkharytonov.composecontacts.presentation.base.UiState

data class ContactDetailState(
    val uuid: String? = null,
    val name: String? = null,
    val surname: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val dateOfBirth: String? = null,
    val iconImage: String? = null,
    val category: Category? = null
) : UiState