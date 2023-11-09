package com.danilkharytonov.composecontacts.presentation.contacts_view

import com.danilkharytonov.composecontacts.presentation.uimodel.UiCategory
import com.danilkharytonov.composecontacts.presentation.uimodel.UiContactUser
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class ContactsUiState(
    val searchText: String = "",
    val currentCategoryText: String = "All",
    val currentCategory: UiCategory = UiCategory.ALL,
    val contactsList: PersistentList<UiContactUser> = persistentListOf(),
    val isExpanded: Boolean = false
)