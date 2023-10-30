package com.danilkharytonov.composecontacts.presentation.create_user_view

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.presentation.activity.ui.theme.ComposeContactsTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateUser(viewModel: CreateUserViewModel) {
    ComposeContactsTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CreateUserView(viewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateUserView(viewModel: CreateUserViewModel = koinViewModel()) {
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
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(R.string.creating_user),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(50.dp),
                fontSize = 30.sp,
            )

            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = "Icon",
                    fontSize = 16.sp
                )

                AsyncImage(
                    model = state.savedUser.iconImage,
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
            }

            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = stringResource(R.string.your_name),
                    fontSize = 16.sp
                )
                TextField(
                    value = state.savedUser.name,
                    onValueChange = { text ->
                        viewModel.updateNameEventHandle(text)
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            CreateSpace()
            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = stringResource(R.string.surname),
                    fontSize = 16.sp
                )
                TextField(
                    value = state.savedUser.surname,
                    onValueChange = { text ->
                        viewModel.updateSurnameEventHandle(text)
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            CreateSpace()
            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = stringResource(R.string.phone_number),
                    fontSize = 16.sp
                )
                TextField(
                    value = state.savedUser.phoneNumber,
                    onValueChange = { text ->
                        viewModel.updatePhoneEventNumber(text)
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            CreateSpace()
            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = stringResource(R.string.email),
                    fontSize = 16.sp
                )
                TextField(
                    value = state.savedUser.email,
                    onValueChange = { text ->
                        viewModel.updateEmailEventHandle(text)
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            CreateSpace()
            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = stringResource(R.string.date_of_birth),
                    fontSize = 16.sp
                )
                TextField(
                    value = state.savedUser.dateOfBirth,
                    onValueChange = { text ->
                        viewModel.updateDateOfBirthHandle(text)
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Button(
                onClick = {
                    viewModel.handleSaveUser()
                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(30.dp)
            ) {
                Text(
                    text = stringResource(R.string.create),
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