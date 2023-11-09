package com.danilkharytonov.composecontacts.presentation.add_contacts.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.presentation.uimodel.UiCategory
import kotlinx.collections.immutable.PersistentMap

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertAddContactDialog(
    onDismissRequest: () -> Unit,
    expandMenu: () -> Unit,
    currentCategoryText: String,
    isExpanded: Boolean,
    categories: PersistentMap<UiCategory, String>,
    categoryOnClick: (UiCategory) -> Unit,
    confirmButtonClick: () -> Unit,
    dismissButtonClick: () -> Unit,
) {
    AlertDialog(onDismissRequest = {
        onDismissRequest()
    }, title = {
        Text(stringResource(R.string.add_contact))
    }, text = {
        Box(
            modifier = Modifier.padding(top = 7.dp)
        ) {
            ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = {
                expandMenu()
            }) {
                TextField(
                    modifier = Modifier.menuAnchor(),
                    readOnly = true,
                    value = currentCategoryText,
                    onValueChange = {},
                    label = { Text(stringResource(R.string.category)) },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                )
                ExposedDropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = { expandMenu() }) {
                    CategoryItemList(
                        categories = categories,
                        expandMenu = { expandMenu() },
                        categoryOnClick = { categoryOnClick(it) }
                    )
                }
            }
        }
    }, confirmButton = {
        Button(onClick = {
            confirmButtonClick()
        }) {
            Text(stringResource(id = R.string.save))
        }
    }, dismissButton = {
        Button(onClick = {
            dismissButtonClick()
        }) {
            Text(stringResource(R.string.exit))
        }
    })
}


