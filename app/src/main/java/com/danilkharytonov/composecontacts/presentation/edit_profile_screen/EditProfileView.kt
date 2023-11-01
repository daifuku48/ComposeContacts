package com.danilkharytonov.composecontacts.presentation.edit_profile_screen

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.danilkharytonov.composecontacts.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileView(viewModel: EditProfileViewModel) {
    val state by viewModel.uiState.collectAsState()

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                viewModel.updateIconEventHandle(uri.toString())
            }
        }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.editing_user),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(50.dp),
                fontSize = 30.sp,
            )

            Text(
                text = stringResource(R.string.icon),
                fontSize = 16.sp
            )

            AsyncImage(
                model = state.iconImage,
                contentDescription = stringResource(R.string.user_icon),
                modifier = Modifier
                    .clickable {
                        launcher.launch(
                            PickVisualMediaRequest(
                                mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo
                            )
                        )
                    }
                    .size(100.dp),
                error = painterResource(id = R.drawable.baseline_person_24)
            )

            TextField(
                value = state.name,
                onValueChange = { text ->
                    viewModel.updateNameEventHandle(text)
                },
                label = { Text(text = stringResource(R.string.your_name)) }
            )

            com.danilkharytonov.composecontacts.presentation.create_user_view.CreateSpace()

            TextField(
                value = state.surname,
                onValueChange = { text ->
                    viewModel.updateSurnameEventHandle(text)
                },
                label = { Text(text = stringResource(R.string.surname)) }
            )

            com.danilkharytonov.composecontacts.presentation.create_user_view.CreateSpace()

            TextField(
                value = state.phoneNumber,
                onValueChange = { text ->
                    viewModel.updatePhoneEventNumber(text)
                },
                label = { Text(text = stringResource(R.string.phone_number)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

            com.danilkharytonov.composecontacts.presentation.create_user_view.CreateSpace()

            TextField(
                value = state.email,
                onValueChange = { text ->
                    viewModel.updateEmailEventHandle(text)
                },
                label = { Text(text = stringResource(R.string.email)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            com.danilkharytonov.composecontacts.presentation.create_user_view.CreateSpace()

            TextField(
                value = state.date,
                onValueChange = { text ->
                    viewModel.updateDateOfBirthHandle(text)
                },
                label = { Text(text = stringResource(R.string.date_of_birth)) },
            )

            Button(
                onClick = {
                    viewModel.handleEditUser()
                }, modifier = Modifier
                    .padding(30.dp)
            ) {
                Text(
                    text = stringResource(R.string.save),
                    fontSize = 20.sp
                )
            }
        }
    }
}


@Composable
fun CreateSpace() {
    Spacer(Modifier.padding(10.dp))
}