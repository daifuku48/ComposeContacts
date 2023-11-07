package com.danilkharytonov.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.danilkharytonov.data.database.model.SubUserEntity
import com.danilkharytonov.domain.model.Category


@Dao
interface SubUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(subUserEntity: SubUserEntity)

    @Query("DELETE FROM sub_user_table WHERE uuid=:uuid")
    fun deleteUserByUuid(uuid: String)

    @Query("SELECT * FROM sub_user_table WHERE uuid=:uuid")
    fun getUserById(uuid: String): SubUserEntity

    @Query("SELECT * FROM sub_user_table WHERE category=:category")
    fun getUsersByCategory(category: Category): List<SubUserEntity>

    @Query("SELECT * FROM sub_user_table")
    fun getAllUsers(): List<SubUserEntity>
}