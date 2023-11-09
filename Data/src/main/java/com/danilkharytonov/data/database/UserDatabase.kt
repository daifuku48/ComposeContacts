package com.danilkharytonov.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.danilkharytonov.data.database.dao.MainUserDao
import com.danilkharytonov.data.database.dao.SubUserDao
import com.danilkharytonov.data.database.model.MainUserEntity
import com.danilkharytonov.data.database.model.SubUserEntity

@Database(
    version = 10,
    entities = [MainUserEntity::class, SubUserEntity::class],
    exportSchema = false
)
@TypeConverters(CategoryConverter::class)
internal abstract class UserDatabase : RoomDatabase() {
    abstract fun getMainUserDao(): MainUserDao
    abstract fun getSubUserDao(): SubUserDao
}