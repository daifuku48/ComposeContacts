package com.danilkharytonov.composecontacts.presentation.main_user_view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.danilkharytonov.composecontacts.R

@Composable
fun MainUserView(viewModel: MainUserViewModel) {
    val state by viewModel.uiState.collectAsState()

    if (state.isUserEmpty) {
        viewModel.navigateToCreatingMainUser()
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            } else {
                Row(modifier = Modifier.padding(30.dp)) {
                    AsyncImage(
                        model = state.user.iconImage,
                        contentDescription = stringResource(R.string.user_icon),
                        modifier = Modifier.size(100.dp),
                    )
                    Log.d("image", state.user.iconImage)
                    Column {
                        Text(text = "Name: ${state.user.name}, ${state.user.surname}")
                        Text(text = "Phone: ${state.user.phoneNumber}")
                        Text(text = "Email: ${state.user.email}")
                        Text(text = "Date: ${state.user.dateOfBirth}")
                    }
                }

                Button(
                    onClick = {
                        // Handle button click
                    }, modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(100.dp)
                ) {
                    Text(text = stringResource(R.string.contacts), fontSize = 30.sp)
                }
            }
        }
    }
}