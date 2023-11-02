package com.danilkharytonov.composecontacts.presentation.contacts_view

import com.danilkharytonov.composecontacts.data.model.ContactUser
import com.danilkharytonov.composecontacts.domain.model.Category
import com.danilkharytonov.composecontacts.presentation.base.UiState
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class ContactsState(
    val searchText: String = "",
    val currentCategoryText: String = "All",
    val currentCategory: Category = Category.ALL,
    val contactsList: PersistentList<ContactUser> = persistentListOf(),
    val isExpanded: Boolean = false
) : UiState