package com.danilkharytonov.composecontacts.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.danilkharytonov.composecontacts.data.model.ContactUser
import com.danilkharytonov.composecontacts.domain.model.Category

@Entity(tableName = "sub_user_table")
data class SubUserEntity(
    @PrimaryKey()
    var uuid: String = MAIN_USER_ID,
    var name: String,
    var surname: String,
    var phoneNumber: String,
    var email: String,
    var dateOfBirth: String,
    var iconImage: String,
    val category: Category
)

fun SubUserEntity.toDomain(): ContactUser {
    return ContactUser(
        uuid = uuid,
        name = name,
        surname = surname,
        phoneNumber = phoneNumber,
        email = email,
        dateOfBirth = dateOfBirth,
        iconImage = iconImage,
        category = category
    )
}