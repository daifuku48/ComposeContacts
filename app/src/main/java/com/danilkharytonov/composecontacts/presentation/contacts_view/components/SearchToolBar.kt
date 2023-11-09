package com.danilkharytonov.composecontacts.presentation.contacts_view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.presentation.add_contacts.components.CategoryItemList
import com.danilkharytonov.composecontacts.presentation.uimodel.UiCategory
import kotlinx.collections.immutable.ImmutableMap

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchToolBar(
    searchText: String,
    searchTextChanged: (String) -> Unit,
    isExpandMenu: Boolean,
    expandMenu: () -> Unit,
    currentCategoryText: String,
    categories: ImmutableMap<UiCategory, String>,
    onClickCategory: (UiCategory) -> Unit,
) {
    Row(modifier = Modifier.padding(10.dp)) {
        OutlinedTextField(
            value = searchText,
            onValueChange = { text ->
                searchTextChanged(text)
            },
            label = { Text(text = stringResource(R.string.search)) },
            modifier = Modifier.weight(0.6f)
        )
        Box(
            modifier = Modifier
                .weight(0.4f)
                .padding(top = 7.dp)
        ) {
            ExposedDropdownMenuBox(
                expanded = isExpandMenu,
                onExpandedChange = {
                    expandMenu()
                }
            ) {
                TextField(
                    modifier = Modifier.menuAnchor(),
                    readOnly = true,
                    value = currentCategoryText,
                    onValueChange = {},
                    label = { Text(stringResource(R.string.category)) },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandMenu) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                )
                ExposedDropdownMenu(
                    expanded = isExpandMenu,
                    onDismissRequest = { expandMenu() }
                ) {
                    CategoryItemList(
                        categories = categories,
                        expandMenu = { expandMenu() },
                        categoryOnClick = { onClickCategory(it) }
                    )
                }
            }
        }
    }
}
