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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.domain.model.Category
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsView(
    viewModel: ContactsViewModel
) {
    val state by viewModel.uiState.collectAsState()
    val categoryList = mapOf(
        Category.ALL to stringResource(id = R.string.Category_All),
        Category.FAMILY to stringResource(id = R.string.Category_Family),
        Category.FRIENDS to stringResource(id = R.string.Category_Friends),
        Category.WORK to stringResource(id = R.string.Category_Work)
    )
    Column(modifier = Modifier.fillMaxSize()) {

        Row(modifier = Modifier.padding(10.dp)) {
            OutlinedTextField(
                value = state.searchText,
                onValueChange = { text ->
                    viewModel.handleChangedSearchText(text)
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
                        viewModel.handleExpandMenu()
                    }
                ) {
                    TextField(
                        value = state.currentCategoryText,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { TrailingIcon(expanded = state.isExpanded) },
                        modifier = Modifier.menuAnchor()
                    )

                    ExposedDropdownMenu(
                        expanded = state.isExpanded,
                        onDismissRequest = { viewModel.handleExpandMenu() }
                    ) {
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = stringResource(id = R.string.Category_All),
                                    fontSize = 16.sp
                                )
                            },
                            onClick = {
                                viewModel.handleChangedCategory(
                                    Category.ALL,
                                    categoryText = categoryList[Category.ALL]!!
                                )
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = stringResource(id = R.string.Category_Family),
                                    fontSize = 16.sp
                                )
                            },
                            onClick = {
                                viewModel.handleChangedCategory(
                                    Category.FAMILY,
                                    categoryText = categoryList[Category.FAMILY]!!
                                )
                                viewModel.handleExpandMenu()
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = stringResource(id = R.string.Category_Friends),
                                    fontSize = 16.sp
                                )
                            },
                            onClick = {
                                viewModel.handleChangedCategory(
                                    Category.FRIENDS,
                                    categoryText = categoryList[Category.FRIENDS]!!
                                )
                                viewModel.handleExpandMenu()
                            }
                        )
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = stringResource(id = R.string.Category_Work),
                                    fontSize = 16.sp
                                )
                            },
                            onClick = {
                                viewModel.handleChangedCategory(
                                    Category.WORK,
                                    categoryText = categoryList[Category.WORK]!!
                                )
                                viewModel.handleExpandMenu()
                            }
                        )
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
                            //Navigate to user details
                        }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
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
            onClick = { }, modifier = Modifier
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