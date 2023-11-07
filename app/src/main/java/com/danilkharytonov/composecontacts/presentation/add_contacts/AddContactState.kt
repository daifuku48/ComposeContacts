package com.danilkharytonov.composecontacts.presentation.add_contacts

import com.danilkharytonov.core.base.UiState
import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.model.ContactUser
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf


data class AddContactState(
    val contactList: PersistentList<ContactUser> = persistentListOf(),
    val savedUser: ContactUser? = null,
    val isExpanded: Boolean = false,
    val currentCategoryText: String = "All",
    val currentCategory: Category = Category.ALL,
    val isPopupAddContactVisible: Boolean = false
) : UiState