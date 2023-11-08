package com.danilkharytonov.composecontacts.presentation.edit_profile_screen

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.presentation.create_user_view.components.TextFieldsUser

@Composable
fun EditProfileView(viewModel: EditProfileViewModel) {
    val state by viewModel.state.collectAsState(EditProfileUiState())

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                viewModel.updateIcon(uri.toString())
            }
        }

    TextFieldsUser(
        titleText = stringResource(R.string.editing_user),
        iconImage = state.iconImage,
        onClickIconImage = {
            launcher.launch(
                PickVisualMediaRequest(
                    mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo
                )
            )
        },
        name = state.name,
        nameChanged = { viewModel.updateName(it) },
        surname = state.surname,
        surnameChanged = { viewModel.updateSurname(it) },
        phoneNumber = state.phoneNumber,
        phoneNumberChanged = { viewModel.updatePhone(it) },
        email = state.email,
        emailChanged = { viewModel.updateEmail(it) },
        dateOfBirth = state.date,
        dateOfBirthChanged = { viewModel.updateDateOfBirth(it) },
        onButtonClick = { viewModel.editUser() },
        buttonText = stringResource(R.string.save)
    )
}