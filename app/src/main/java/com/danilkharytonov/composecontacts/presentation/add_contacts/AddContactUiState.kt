package com.danilkharytonov.composecontacts.presentation.add_contacts

import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.model.ContactUser
import com.danilkharytonov.domain.use_cases.add_contacts_view.AddContactState
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class AddContactUiState(
    val contactList: PersistentList<ContactUser> = persistentListOf(),
    val savedUser: ContactUser? = null,
    val isExpanded: Boolean = false,
    val currentCategoryText: String = "All",
    val currentCategory: Category = Category.ALL,
    val isPopupAddContactVisible: Boolean = false
)

fun AddContactState.toUi() : AddContactUiState{
    return AddContactUiState(
        contactList = contactList,
        savedUser = savedUser,
        isExpanded = isExpanded,
        currentCategoryText = currentCategoryText,
        currentCategory = currentCategory,
        isPopupAddContactVisible = isPopupAddContactVisible
    )
}