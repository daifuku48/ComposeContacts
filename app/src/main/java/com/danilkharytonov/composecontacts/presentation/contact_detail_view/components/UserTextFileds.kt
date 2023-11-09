package com.danilkharytonov.composecontacts.presentation.contact_detail_view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.presentation.uimodel.UiCategory

@Composable
fun UserTextFields(
    iconImage: String?,
    name: String?,
    surname: String?,
    email: String?,
    phoneNumber: String?,
    dateOfBirth: String?,
    category: UiCategory?,
    onClickDeleteUser: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = iconImage,
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
        CreateSpace()
        name?.let { name ->
            surname?.let { surname ->
                Text(text = stringResource(id = R.string.Name, name, surname))
            }
        }
        CreateSpace()
        email?.let { email ->
            Text(text = stringResource(id = R.string.Email, email))
        }
        CreateSpace()
        phoneNumber?.let { phoneNumber ->
            Text(text = stringResource(id = R.string.Phone, phoneNumber))
        }
        CreateSpace()
        dateOfBirth?.let { dateOfBirth ->
            Text(text = stringResource(id = R.string.Date, dateOfBirth))
        }
        CreateSpace()
        category?.let { category ->
            Text(text = stringResource(id = R.string.Category, category.name))
        }
        CreateSpace()
        Button(onClick = { onClickDeleteUser() }) {
            Text(text = stringResource(R.string.delete_user))
        }
    }
}

@Composable
fun CreateSpace() {
    Spacer(modifier = Modifier.padding(10.dp))
}