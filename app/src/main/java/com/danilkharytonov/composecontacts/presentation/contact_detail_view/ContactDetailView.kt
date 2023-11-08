package com.danilkharytonov.composecontacts.presentation.contact_detail_view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.danilkharytonov.composecontacts.presentation.activity.MainActivity.Companion.LOAD_CONTACT_USER
import com.danilkharytonov.composecontacts.presentation.contact_detail_view.components.DeleteUserAlertDialog
import com.danilkharytonov.composecontacts.presentation.contact_detail_view.components.UserTextFields

@Composable
fun ContactDetailView(viewModel: ContactDetailViewModel, userId: String) {
    val state by viewModel.state.collectAsState(ContactDetailUiState())

    LaunchedEffect(key1 = LOAD_CONTACT_USER, block = {
        viewModel.loadUser(userId)
    })

    UserTextFields(
        iconImage = state.iconImage,
        name = state.name,
        surname = state.surname,
        email = state.email,
        phoneNumber = state.phoneNumber,
        dateOfBirth = state.dateOfBirth,
        category = state.category,
        onClickDeleteUser = {
            viewModel.showPopUpToDeleteContact()
        }
    )
    if (state.isVisiblePopUpDeleteDialog) {
        DeleteUserAlertDialog(
            dismissRequest = {
                viewModel.hidePopUpDeleteContact()
            },
            confirmClick = {
                viewModel.hidePopUpDeleteContact()
                viewModel.deleteUser(userId)
            }
        )
    }
}