package com.danilkharytonov.composecontacts.domain.repository

import com.danilkharytonov.composecontacts.data.model.ContactUser
import com.danilkharytonov.composecontacts.domain.model.Category
import kotlinx.collections.immutable.PersistentList

interface SubUserLocalRepository {
    fun insertUser(user: ContactUser)
    fun getAllUsers(): PersistentList<ContactUser>
    fun getUsersByCategory(category: Category): PersistentList<ContactUser>
    fun deleteUserById(uuid: String)
    fun getUserById(uuid: String): ContactUser
}