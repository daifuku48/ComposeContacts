package com.danilkharytonov.composecontacts.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.danilkharytonov.composecontacts.data.database.dao.MainUserDao
import com.danilkharytonov.composecontacts.data.database.dao.SubUserDao
import com.danilkharytonov.composecontacts.data.database.model.MainUserEntity
import com.danilkharytonov.composecontacts.data.database.model.SubUserEntity

@Database(
    version = 9,
    entities = [MainUserEntity::class, SubUserEntity::class],
    exportSchema = false
)
@TypeConverters(CategoryConverter::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getMainUserDao(): MainUserDao
    abstract fun getSubUserDao(): SubUserDao
}