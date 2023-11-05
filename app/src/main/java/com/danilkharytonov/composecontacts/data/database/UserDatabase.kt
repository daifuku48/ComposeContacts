package com.danilkharytonov.composecontacts.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 8,
    entities = [MainUserEntity::class, SubUserEntity::class],
    exportSchema = false
)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getMainUserDao(): MainUserDao
    abstract fun getSubUserDao(): SubUserDao
}