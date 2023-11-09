package com.danilkharytonov.composecontacts.presentation.main_user_view.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun MainUserButton(
    onClick: () -> Unit,
    buttonText: String,
    modifier: Modifier
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = modifier
    ) {
        Text(text = buttonText, fontSize = 30.sp)
    }
}