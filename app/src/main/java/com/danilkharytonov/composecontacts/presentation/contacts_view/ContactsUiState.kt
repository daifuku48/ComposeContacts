package com.danilkharytonov.composecontacts.presentation.contacts_view

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class ContactsUiState(
    val searchText: String = "",
    val currentCategoryText: String = "All",
    val currentCategory: UiCategory = UiCategory.ALL,
    val contactsList: PersistentList<UiContactUser> = persistentListOf(),
    val isExpanded: Boolean = false
)