package com.danilkharytonov.composecontacts.presentation.main_user_view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danilkharytonov.composecontacts.R

@Composable
fun MainUserView(viewModel: MainUserViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(modifier = Modifier.padding(30.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_person_24),
                    contentDescription = null,
                    modifier = Modifier.size(150.dp)
                )
                Column {
                    Text(text = "Name: Name, Surname")
                    Text(text = "Phone: 484 484 93 93")
                    Text(text = "Email: test@gmail.com")
                    Text(text = "Date: 01.01.1900")
                }
            }

            Button(
                onClick = {

                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(100.dp)
            ) {
                Text(text = stringResource(R.string.contacts), fontSize = 30.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainUserPreview() {
    //MainUserView()
}