package com.danilkharytonov.domain.use_cases.contact_detail_view

import com.danilkharytonov.core.base.UiState
import com.danilkharytonov.domain.model.Category

data class ContactDetailState(
    val uuid: String? = null,
    val name: String? = null,
    val surname: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val dateOfBirth: String? = null,
    val iconImage: String? = null,
    val category: Category? = null,
    val isVisiblePopUpDeleteDialog: Boolean = false
) : UiState