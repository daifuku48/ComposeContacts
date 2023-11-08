package com.danilkharytonov.composecontacts.presentation.add_contacts

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.presentation.activity.MainActivity.Companion.LOAD_CONTACT_USER
import com.danilkharytonov.composecontacts.presentation.add_contacts.components.AddContactItem
import com.danilkharytonov.composecontacts.presentation.add_contacts.components.AlertAddContactDialog
import com.danilkharytonov.domain.model.Category
import kotlinx.collections.immutable.persistentMapOf
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddContactView(viewModel: AddContactViewModel) {
    val state = viewModel.uiModel
    val context = LocalContext.current
    val categoryMap = remember {
        persistentMapOf(
            Category.ALL to ContextCompat.getString(context, R.string.Category_All),
            Category.FAMILY to ContextCompat.getString(context, R.string.Category_Family),
            Category.FRIENDS to ContextCompat.getString(context, R.string.Category_Friends),
            Category.WORK to ContextCompat.getString(context, R.string.Category_Work)
        )
    }
    LaunchedEffect(key1 = LOAD_CONTACT_USER) {
        viewModel.loadUsers()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(8.dp)
    ) {
        itemsIndexed(state.contactList) { index, item ->
            if (index == state.contactList.size - 4) {
                viewModel.loadUserToEnd()
            }
            AddContactItem(iconImage = item.iconImage, name = item.name,
                surname = item.surname,
                onClick = {
                    viewModel.setSavedUser(item)
                    viewModel.showPopUpAddContact()
                })
        }
    }
    if (state.isPopupAddContactVisible) {
        AlertAddContactDialog(
            onDismissRequest = { viewModel.hidePopUpAddContact() },
            expandMenu = { viewModel.expandMenu() },
            currentCategoryText = state.currentCategoryText,
            isExpanded = state.isExpanded,
            categories = categoryMap,
            categoryOnClick = { category ->
                viewModel.setCategory(category)
                viewModel.expandMenu()
            },
            confirmButtonClick = {
                viewModel.hidePopUpAddContact()
                viewModel.saveUser()
                viewModel.navigateToContactScreen()
            }, dismissButtonClick = {
                viewModel.hidePopUpAddContact()
                viewModel.declineSavedUser()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddContactView() {
    AddContactView(koinViewModel())
}
