package com.danilkharytonov.composecontacts.presentation.contacts_view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.getString
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.presentation.activity.MainActivity.Companion.LOAD_CONTACT_USER
import com.danilkharytonov.composecontacts.presentation.add_contacts.components.AddContactItem
import com.danilkharytonov.composecontacts.presentation.contacts_view.components.AddUserActionButton
import com.danilkharytonov.composecontacts.presentation.contacts_view.components.SearchToolBar
import com.danilkharytonov.domain.model.Category
import org.koin.androidx.compose.koinViewModel


@Composable
fun ContactsView(
    viewModel: ContactsViewModel
) {
    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    val categoryMap by remember {
        mutableStateOf(
            mapOf(
                Category.ALL to getString(context, R.string.Category_All),
                Category.FAMILY to getString(context, R.string.Category_Family),
                Category.FRIENDS to getString(context, R.string.Category_Friends),
                Category.WORK to getString(context, R.string.Category_Work)
            )
        )
    }
    LaunchedEffect(key1 = LOAD_CONTACT_USER, block = {
        viewModel.getContactEvent()
    })

    Column(modifier = Modifier.fillMaxSize()) {
        SearchToolBar(
            searchText = state.searchText,
            searchTextChanged = { viewModel.changedSearchText(it) },
            isExpandMenu = state.isExpanded,
            expandMenu = { viewModel.expandMenu() },
            currentCategoryText = state.currentCategoryText,
            categories = categoryMap,
            onClickCategory = { category ->
                viewModel.changedCategory(
                    category,
                    categoryText = categoryMap[category]!!
                )
            }
        )

        LazyColumn {
            items(state.contactsList.size) { index ->
                AddContactItem(
                    item = state.contactsList[index],
                    onClick = { viewModel.navigateToDetailContact(state.contactsList[index].uuid) }
                )
            }
        }
    }
    AddUserActionButton(
        onClick = {
            viewModel.navigateToAddContact()
        }
    )
}


@Preview(showBackground = true)
@Composable
fun ContactsPreview() {
    ContactsView(koinViewModel())
}