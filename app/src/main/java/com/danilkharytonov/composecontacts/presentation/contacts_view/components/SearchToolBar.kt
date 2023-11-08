package com.danilkharytonov.composecontacts.presentation.contacts_view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.domain.model.Category
import kotlinx.collections.immutable.PersistentMap

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchToolBar(
    searchText: String,
    searchTextChanged: (String) -> Unit,
    isExpandMenu: Boolean,
    expandMenu: () -> Unit,
    currentCategoryText: String,
    categories: PersistentMap<Category, String>,
    onClickCategory: (Category) -> Unit,
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
                    Category.values().forEach { category ->
                        key(category) {
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = categories[category]!!,
                                        fontSize = 16.sp
                                    )
                                },
                                onClick = {
                                    onClickCategory(category)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
