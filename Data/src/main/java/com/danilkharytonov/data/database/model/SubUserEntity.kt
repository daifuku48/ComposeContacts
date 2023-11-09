package com.danilkharytonov.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.model.ContactUser

@Entity(tableName = "sub_user_table")
internal data class SubUserEntity(
    @PrimaryKey()
    var uuid: String,
    var name: String,
    var surname: String,
    var phoneNumber: String,
    var email: String,
    var dateOfBirth: String,
    var iconImage: String,
    val category: Category
) {
    fun toDomain(): ContactUser {
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
}