package com.danilkharytonov.composecontacts.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface MainUserDao {
    @Query("SELECT * FROM main_user_table WHERE uuid=:uuid")
    suspend fun getMainUser(uuid: String): MainUserEntity

    @Update
    suspend fun updateMainUser(userEntity: MainUserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMainUser(userEntity: MainUserEntity)
}