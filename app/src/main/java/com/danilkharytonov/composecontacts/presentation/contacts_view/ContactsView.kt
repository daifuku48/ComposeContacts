package com.danilkharytonov.composecontacts.presentation.contacts_view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getString
import coil.compose.AsyncImage
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.presentation.activity.MainActivity.Companion.LOAD_CONTACT_USER
import com.danilkharytonov.domain.model.Category
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
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

        Row(modifier = Modifier.padding(10.dp)) {
            OutlinedTextField(
                value = state.searchText,
                onValueChange = { text ->
                    viewModel.changedSearchText(text)
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
                    expanded = state.isExpanded,
                    onExpandedChange = {
                        viewModel.expandMenu()
                    }
                ) {
                    TextField(
                        modifier = Modifier.menuAnchor(),
                        readOnly = true,
                        value = state.currentCategoryText,
                        onValueChange = {},
                        label = { Text(stringResource(R.string.category)) },
                        trailingIcon = { TrailingIcon(expanded = state.isExpanded) },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    )
                    ExposedDropdownMenu(
                        expanded = state.isExpanded,
                        onDismissRequest = { viewModel.expandMenu() }
                    ) {
                        Category.values().forEach { category ->
                            key(category) {
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = categoryMap[category]!!,
                                            fontSize = 16.sp
                                        )
                                    },
                                    onClick = {
                                        viewModel.changedCategory(
                                            category,
                                            categoryText = categoryMap[category]!!
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }

        LazyColumn {
            items(state.contactsList.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 4.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                        .clickable {
                            viewModel.navigateToDetailContact(state.contactsList[index].uuid)
                        }
                ) {

                    AsyncImage(
                        model = state.contactsList[index].iconImage,
                        contentDescription = null
                    )

                    Column(modifier = Modifier.padding(start = 10.dp)) {
                        Text(text = state.contactsList[index].name, fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = state.contactsList[index].surname)
                    }
                }
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = {
                viewModel.navigateToAddContact()
            }, modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_person_add_alt_1_24),
                contentDescription = null
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ContactsPreview() {
    ContactsView(koinViewModel())
}