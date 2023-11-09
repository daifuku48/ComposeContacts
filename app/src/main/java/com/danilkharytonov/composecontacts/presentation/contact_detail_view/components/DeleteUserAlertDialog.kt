package com.danilkharytonov.composecontacts.presentation.contact_detail_view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.danilkharytonov.composecontacts.R

@Composable
fun DeleteUserAlertDialog(
    dismissRequest: () -> Unit,
    confirmClick: () -> Unit
){
    AlertDialog(onDismissRequest = {
        dismissRequest()
    }, title = {
        Text(stringResource(R.string.add_contact))
    }, text = {
        Box(
            modifier = Modifier.padding(top = 7.dp)
        ) {
            Text(text = stringResource(R.string.are_you_sure_to_remove_user))
        }
    }, confirmButton = {
        Button(onClick = {
            confirmClick()
        }) {
            Text(text = stringResource(R.string.i_m_sure))
        }
    }, dismissButton = {
        Button(onClick = {
            dismissRequest()
        }) {
            Text(text = stringResource(R.string.dismiss))
        }
    })
}