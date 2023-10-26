package com.danilkharytonov.composecontacts.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [MainUserEntity::class], exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getMainUserDao(): MainUserDao
}