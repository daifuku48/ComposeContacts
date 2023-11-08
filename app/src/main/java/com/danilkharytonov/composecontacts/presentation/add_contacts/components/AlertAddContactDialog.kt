package com.danilkharytonov.composecontacts.presentation.add_contacts.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertAddContactDialog(
    onDismissRequest: () -> Unit,
    expandMenu: () -> Unit,
    currentCategoryText: String,
    isExpanded: Boolean,
    categories: Map<Category, String>,
    categoryOnClick: (Category) -> Unit,
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
                    Category.values().forEach { category ->
                        key(category) {
                            DropdownMenuItem(text = {
                                Text(
                                    text = categories[category]!!, fontSize = 16.sp
                                )
                            }, onClick = {
                                categoryOnClick(category)
                                expandMenu()
                            })
                        }
                    }
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