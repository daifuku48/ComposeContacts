package com.danilkharytonov.composecontacts.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.danilkharytonov.composecontacts.data.database.model.MainUserEntity

@Dao
interface MainUserDao {
    @Query("SELECT * FROM main_user_table")
    suspend fun getMainUser(): MainUserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMainUser(userEntity: MainUserEntity)
}