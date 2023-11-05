package com.danilkharytonov.composecontacts.presentation.add_contacts

import com.danilkharytonov.composecontacts.data.model.ContactUser
import com.danilkharytonov.composecontacts.domain.model.Category
import com.danilkharytonov.composecontacts.presentation.base.UiState
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class AddContactState(
    val contactList: PersistentList<ContactUser> = persistentListOf(),
    val savedUser: ContactUser? = null,
    val isExpanded: Boolean = false,
    val currentCategoryText: String = "All",
    val currentCategory: Category = Category.ALL,
) : UiState