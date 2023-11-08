package com.danilkharytonov.composecontacts.presentation.contacts_view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.danilkharytonov.composecontacts.R

@Composable
fun AddUserActionButton(onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = {
                onClick()
            }, modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_person_add_alt_1_24),
                contentDescription = null
            )
        }
    }
}
