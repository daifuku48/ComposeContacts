package com.danilkharytonov.composecontacts.presentation.contact_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.presentation.activity.MainActivity.Companion.LOAD_CONTACT_USER

@Composable
fun ContactDetailView(viewModel: ContactDetailViewModel, userId: String) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = LOAD_CONTACT_USER, block = {
        viewModel.loadUser(userId)
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = state.iconImage,
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
        CreateSpace()
        state.name?.let { name ->
            state.surname?.let { surname ->
                Text(text = stringResource(id = R.string.Name, name, surname))
            }
        }
        CreateSpace()
        state.email?.let { email ->
            Text(text = stringResource(id = R.string.Email, email))
        }
        CreateSpace()
        state.phoneNumber?.let { phoneNumber ->
            Text(text = stringResource(id = R.string.Phone, phoneNumber))
        }
        CreateSpace()
        state.dateOfBirth?.let { dateOfBirth ->
            Text(text = stringResource(id = R.string.Date, dateOfBirth))
        }
        CreateSpace()
        state.category?.let { category ->
            Text(text = stringResource(id = R.string.Category, category.name))
        }
        CreateSpace()
        Button(onClick = { viewModel.deleteUser(userId) }) {
            Text(text = stringResource(R.string.delete_user))
        }
    }
}

@Composable
fun CreateSpace() {
    Spacer(modifier = Modifier.padding(10.dp))
}