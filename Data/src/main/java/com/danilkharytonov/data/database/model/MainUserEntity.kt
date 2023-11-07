package com.danilkharytonov.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.danilkharytonov.domain.model.MAIN_USER_ID

@Entity("main_user_table")
internal data class MainUserEntity(
    @PrimaryKey
    var uuid: String = MAIN_USER_ID,
    var name: String,
    var surname: String,
    var phoneNumber: String,
    var email: String,
    var dateOfBirth: String,
    var iconImage: String
)