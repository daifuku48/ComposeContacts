package com.danilkharytonov.composecontacts.presentation.create_user_view

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.presentation.activity.ui.theme.ComposeContactsTheme

@Composable
fun CreateUser() {
    ComposeContactsTheme {
        CreateUserView(Modifier.fillMaxSize())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateUserView(modifier: Modifier) {
    var nameField by rememberSaveable {
        mutableStateOf("")
    }
    var surnameField by rememberSaveable {
        mutableStateOf("")
    }
    var phoneNumberField by rememberSaveable {
        mutableStateOf("")
    }
    var emailField by rememberSaveable {
        mutableStateOf("")
    }
    var dateOfBirth by rememberSaveable {
        mutableStateOf("")
    }

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->

        }

    Surface(modifier = modifier) {
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
                Image(
                    painter = painterResource(id = R.drawable.baseline_person_24),
                    contentDescription = stringResource(R.string.user_icon),
                    modifier = Modifier
                        .clickable {
                            launcher.launch(
                                PickVisualMediaRequest(
                                    mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                                )
                            )
                        }
                        .size(100.dp)
                )
            }

            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = stringResource(R.string.your_name),
                    fontSize = 16.sp
                )
                TextField(
                    value = nameField,
                    onValueChange = { text ->
                        nameField = text
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
                    value = surnameField,
                    onValueChange = { text ->
                        surnameField = text
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
                    value = phoneNumberField,
                    onValueChange = { text ->
                        surnameField = text
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
                    value = emailField,
                    onValueChange = { text ->
                        emailField = text
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
                    value = dateOfBirth,
                    onValueChange = { text ->
                        dateOfBirth = text
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Button(onClick = {

            }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
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


@Preview(showBackground = true)
@Composable
fun CreateUserPreview() {
    CreateUserView(Modifier.fillMaxSize())
}