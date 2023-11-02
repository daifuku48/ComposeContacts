package com.danilkharytonov.composecontacts.data.repository

import com.danilkharytonov.composecontacts.data.database.SubUserDao
import com.danilkharytonov.composecontacts.data.database.toDomain
import com.danilkharytonov.composecontacts.data.model.ContactUser
import com.danilkharytonov.composecontacts.data.model.toEntity
import com.danilkharytonov.composecontacts.domain.model.Category
import com.danilkharytonov.composecontacts.domain.repository.SubUserRepository
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

class SubUserRepositoryImpl(private val subUserDao: SubUserDao) : SubUserRepository {
    override fun insertUser(user: ContactUser) {
        subUserDao.insertUser(user.toEntity())
    }

    override fun getAllUsers(): PersistentList<ContactUser> {
        return subUserDao.getAllUsers().map { it.toDomain() }.toPersistentList()
    }

    override fun getUsersByCategory(category: Category): PersistentList<ContactUser> {
        return subUserDao.getUsersByCategory(category).map { it.toDomain() }.toPersistentList()
    }

    override fun deleteUserById(uuid: String) {
        subUserDao.deleteUserByUuid(uuid)
    }

    override fun getUserById(uuid: String): ContactUser {
        return subUserDao.getUserById(uuid).toDomain()
    }
}