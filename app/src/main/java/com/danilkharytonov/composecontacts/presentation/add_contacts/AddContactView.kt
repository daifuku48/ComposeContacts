package com.danilkharytonov.composecontacts.presentation.add_contacts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import coil.compose.AsyncImage
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.domain.model.Category
import com.danilkharytonov.composecontacts.presentation.activity.MainActivity.Companion.LOAD_CONTACT_USER
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactView(viewModel: AddContactViewModel) {
    val state by viewModel.uiState.collectAsState()
    var isPopupVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val categoryMap by remember {
        mutableStateOf(
            mapOf(
                Category.ALL to ContextCompat.getString(context, R.string.Category_All),
                Category.FAMILY to ContextCompat.getString(context, R.string.Category_Family),
                Category.FRIENDS to ContextCompat.getString(context, R.string.Category_Friends),
                Category.WORK to ContextCompat.getString(context, R.string.Category_Work)
            )
        )
    }
    LaunchedEffect(key1 = LOAD_CONTACT_USER) {
        viewModel.handleLoadUserEvent()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(8.dp)
    ) {
        itemsIndexed(state.contactList) { index, item ->
            if (index == state.contactList.size - 4) {
                viewModel.handleLoadUserToEndEvent()
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(all = 4.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(Color.LightGray)
                .clickable {
                    viewModel.handleSetSavedUser(item)
                    isPopupVisible = true
                }) {

                AsyncImage(
                    model = item.iconImage, contentDescription = null
                )

                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(text = item.name, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = item.surname)
                }
            }
        }
    }
    if (isPopupVisible) {
        AlertDialog(onDismissRequest = {
            isPopupVisible = false
        }, title = {
            Text(stringResource(R.string.add_contact))
        }, text = {
            Box(
                modifier = Modifier.padding(top = 7.dp)
            ) {
                ExposedDropdownMenuBox(expanded = state.isExpanded, onExpandedChange = {
                    viewModel.handleExpandMenu()
                }) {

                    TextField(
                        modifier = Modifier.menuAnchor(),
                        readOnly = true,
                        value = state.currentCategoryText,
                        onValueChange = {},
                        label = { Text(stringResource(R.string.category)) },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = state.isExpanded) },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    )
                    ExposedDropdownMenu(expanded = state.isExpanded,
                        onDismissRequest = { viewModel.handleExpandMenu() }) {
                        Category.values().forEach { category ->
                            key(category) {
                                DropdownMenuItem(text = {
                                    Text(
                                        text = categoryMap[category]!!, fontSize = 16.sp
                                    )
                                }, onClick = {
                                    viewModel.handleSetCategory(category)
                                })
                            }
                        }
                    }
                }
            }
        }, confirmButton = {
            Button(onClick = {
                isPopupVisible = false
                viewModel.handleSavedUser()
                viewModel.handleNavigateToContactList()
            }) {
                Text(stringResource(id = R.string.save))

            }
        }, dismissButton = {
            Button(onClick = {
                isPopupVisible = false
                viewModel.declineSavedUser()
            }) {
                Text(stringResource(R.string.exit))
            }
        })
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddContactView() {
    AddContactView(koinViewModel())
}
