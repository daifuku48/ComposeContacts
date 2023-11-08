package com.danilkharytonov.composecontacts.presentation.add_contacts.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.danilkharytonov.domain.model.ContactUser

@Composable
fun AddContactItem(
    item: ContactUser,
    onClick: () -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 4.dp)
        .clip(shape = RoundedCornerShape(10.dp))
        .background(Color.LightGray)
        .clickable {
            onClick()
        }) {

        AsyncImage(
            model = item.iconImage, contentDescription = null
        )

        Column(modifier = Modifier.padding(start = 10.dp)) {
            Text(text = item.name, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = item.surname)
        }
    }
}