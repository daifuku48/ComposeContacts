package com.danilkharytonov.domain.repository

import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.model.ContactUser
import kotlinx.collections.immutable.PersistentList

interface SubUserLocalRepository {
    fun insertUser(user: ContactUser)
    fun getAllUsers(): PersistentList<ContactUser>
    fun getUsersByCategory(category: Category): PersistentList<ContactUser>
    fun deleteUserById(uuid: String)
    fun getUserById(uuid: String): ContactUser
}