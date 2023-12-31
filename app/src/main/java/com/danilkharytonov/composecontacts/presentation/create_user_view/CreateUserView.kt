package com.danilkharytonov.composecontacts.presentation.create_user_view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.presentation.activity.ui.theme.ComposeContactsTheme
import com.danilkharytonov.composecontacts.presentation.create_user_view.components.TextFieldsUser

@Composable
fun CreateUser(viewModel: CreateUserViewModel) {
    ComposeContactsTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CreateUserView(viewModel)
        }
    }
}

@Composable
fun CreateUserView(viewModel: CreateUserViewModel) {
    val state by viewModel.state.collectAsState()

    TextFieldsUser(
        titleText = stringResource(id = R.string.creating_user),
        iconImage = state.iconImage,
        name = state.name,
        nameChanged = { viewModel.updateName(it) },
        surname = state.surname,
        surnameChanged = { viewModel.updateSurname(it) },
        phoneNumber = state.phoneNumber,
        phoneNumberChanged = { viewModel.updatePhone(it) },
        email = state.email,
        emailChanged = { viewModel.updateEmail(it) },
        dateOfBirth = state.dateOfBirth,
        dateOfBirthChanged = { viewModel.updateDateOfBirth(it) },
        onButtonClick = { viewModel.saveUser() },
        updateIcon = { viewModel.updateIcon(it) },
        buttonText = stringResource(R.string.create)
    )
}

@Composable
fun CreateSpace() {
    Spacer(Modifier.padding(10.dp))
}