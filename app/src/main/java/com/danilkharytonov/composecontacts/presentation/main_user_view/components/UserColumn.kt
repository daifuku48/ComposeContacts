package com.danilkharytonov.composecontacts.presentation.main_user_view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.danilkharytonov.composecontacts.R
import java.io.File

@Composable
fun UserColumn(
    iconImage: String?,
    name: String?,
    surname: String?,
    phoneNumber: String?,
    email: String?,
    dateOfBirth: String?
) {
    Row(modifier = Modifier.padding(30.dp)) {
        Image(
            painter = rememberAsyncImagePainter(
                iconImage?.let {
                    File(
                        LocalContext.current.filesDir,
                        it
                    )
                }
            ),
            contentDescription = stringResource(R.string.user_icon),
            modifier = Modifier.size(100.dp),
        )
        Column {
            name?.let { name ->
                surname?.let { surname ->
                    Text(text = stringResource(id = R.string.Name, name, surname))
                }
            }

            phoneNumber?.let {
                Text(text = stringResource(id = R.string.Phone, it))
            }

            email?.let {
                Text(text = stringResource(id = R.string.Email, it))
            }

            dateOfBirth?.let {
                Text(text = stringResource(id = R.string.Date, it))
            }
        }
    }
}