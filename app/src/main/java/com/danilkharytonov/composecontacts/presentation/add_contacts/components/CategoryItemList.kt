package com.danilkharytonov.composecontacts.presentation.add_contacts.components

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.unit.sp
import com.danilkharytonov.composecontacts.presentation.uimodel.UiCategory
import kotlinx.collections.immutable.ImmutableMap

@Composable
fun CategoryItemList(
    categories: ImmutableMap<UiCategory, String>,
    expandMenu: () -> Unit,
    categoryOnClick: (UiCategory) -> Unit
) {
    UiCategory.values().forEach { category ->
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