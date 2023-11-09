package com.danilkharytonov.composecontacts.presentation.add_contacts

import com.danilkharytonov.composecontacts.presentation.contacts_view.UiCategory
import com.danilkharytonov.composecontacts.presentation.contacts_view.UiContactUser
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class AddContactUiState(
    val contactList: PersistentList<UiContactUser> = persistentListOf(),
    val savedUser: UiContactUser? = null,
    val isExpanded: Boolean = false,
    val currentCategoryText: String = "All",
    val currentCategory: UiCategory = UiCategory.ALL,
    val isPopupAddContactVisible: Boolean = false
)