package com.danilkharytonov.composecontacts.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.danilkharytonov.composecontacts.domain.model.User

@Entity("main_user_table")
data class MainUserEntity(
    @PrimaryKey
    var uuid: String,
    var name: String,
    var surname: String,
    var phoneNumber: String,
    var email: String,
    var dateOfBirth: String,
    var iconImage: String
)

fun MainUserEntity.toDomain(): User {
    return User(
        uuid = uuid,
        name = name,
        surname = surname,
        phoneNumber = phoneNumber,
        email = email,
        dateOfBirth = dateOfBirth,
        iconImage = iconImage
    )
}