package com.danilkharytonov.composecontacts.presentation.create_user_view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateSpace

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldsUser(
    titleText: String,
    iconImage: String,
    onClickIconImage: () -> Unit,
    name: String,
    nameChanged: (String) -> Unit,
    surname: String,
    surnameChanged: (String) -> Unit,
    phoneNumber: String,
    phoneNumberChanged: (String) -> Unit,
    email: String,
    emailChanged: (String) -> Unit,
    dateOfBirth: String,
    dateOfBirthChanged: (String) -> Unit,
    onButtonClick: () -> Unit,
    buttonText: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = titleText,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(50.dp),
            fontSize = 30.sp,
        )

        Text(
            text = stringResource(id = R.string.icon),
            fontSize = 16.sp
        )

        AsyncImage(
            model = iconImage,
            contentDescription = stringResource(R.string.user_icon),
            modifier = Modifier
                .clickable {
                    onClickIconImage()
                }
                .size(100.dp),
            error = painterResource(id = R.drawable.baseline_person_24)
        )

        TextField(
            value = name,
            onValueChange = { text ->
                nameChanged(text)
            },
            label = { Text(text = stringResource(R.string.your_name)) }
        )

        CreateSpace()

        TextField(
            value = surname,
            onValueChange = { text ->
                surnameChanged(text)
            },
            label = { Text(text = stringResource(R.string.surname)) }
        )

        CreateSpace()

        TextField(
            value = phoneNumber,
            onValueChange = { text ->
                phoneNumberChanged(text)
            },
            label = { Text(text = stringResource(R.string.phone_number)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        CreateSpace()

        TextField(
            value = email,
            onValueChange = { text ->
                emailChanged(text)
            },
            label = { Text(text = stringResource(R.string.email)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        CreateSpace()

        TextField(
            value = dateOfBirth,
            onValueChange = { text ->
                dateOfBirthChanged(text)
            },
            label = { Text(text = stringResource(R.string.date_of_birth)) },
        )

        Button(
            onClick = {
                onButtonClick()
            }, modifier = Modifier
                .padding(30.dp)
        ) {
            Text(
                text = buttonText,
                fontSize = 20.sp
            )
        }
    }
}