package com.danilkharytonov.composecontacts.presentation.contacts_view

import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.model.ContactUser
import com.danilkharytonov.domain.use_cases.contacts_view.ContactsState
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class ContactsUiState(
    val searchText: String = "",
    val currentCategoryText: String = "All",
    val currentCategory: Category = Category.ALL,
    val contactsList: PersistentList<ContactUser> = persistentListOf(),
    val isExpanded: Boolean = false
)

fun ContactsState.toUi(): ContactsUiState {
    return ContactsUiState(
        searchText = searchText,
        currentCategoryText = currentCategoryText,
        currentCategory = currentCategory,
        contactsList = contactsList,
        isExpanded = isExpanded
    )
}