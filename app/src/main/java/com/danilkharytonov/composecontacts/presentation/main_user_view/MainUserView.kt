package com.danilkharytonov.composecontacts.presentation.main_user_view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.presentation.activity.MainActivity.Companion.UPDATE_MAIN_USER
import com.danilkharytonov.composecontacts.presentation.main_user_view.components.MainUserButton
import com.danilkharytonov.composecontacts.presentation.main_user_view.components.UserColumn

@Composable
fun MainUserView(viewModel: MainUserViewModel) {
    val state = viewModel.uiModel
    LaunchedEffect(key1 = UPDATE_MAIN_USER, block = {
        viewModel.requestUserData()
    })

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            UserColumn(
                iconImage = state.iconImage,
                name = state.name,
                surname = state.surname,
                phoneNumber = state.phoneNumber,
                email = state.email,
                dateOfBirth = state.dateOfBirth
            )

            MainUserButton(
                onClick = { viewModel.navigateToEditingScreen() },
                buttonText = stringResource(R.string.edit_profile),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp)
            )

            MainUserButton(
                onClick = { viewModel.navigateToContactsScreen() },
                buttonText = stringResource(id = R.string.contacts),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp)
            )
        }
    }
}