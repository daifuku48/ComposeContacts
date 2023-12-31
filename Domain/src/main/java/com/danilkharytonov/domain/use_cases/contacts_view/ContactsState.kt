package com.danilkharytonov.domain.use_cases.contacts_view

import com.danilkharytonov.core.base.UiState
import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.model.ContactUser
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class ContactsState(
    val searchText: String = "",
    val currentCategoryText: String = "All",
    val currentCategory: Category = Category.ALL,
    val contactsList: PersistentList<ContactUser> = persistentListOf(),
    val isExpanded: Boolean = false
) : UiState