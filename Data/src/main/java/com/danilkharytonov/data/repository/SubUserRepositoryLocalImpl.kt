package com.danilkharytonov.data.repository

import com.danilkharytonov.data.database.dao.SubUserDao
import com.danilkharytonov.data.database.model.SubUserEntity
import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.model.ContactUser
import com.danilkharytonov.domain.repository.SubUserLocalRepository
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

internal class SubUserRepositoryLocalImpl(
    private val subUserDao: SubUserDao,
) : SubUserLocalRepository {
    override fun insertUser(user: ContactUser) {
        subUserDao.insertUser(user.toEntity())
    }

    override fun getAllUsers(): PersistentList<ContactUser> {
        return subUserDao.getAllUsers().map { it.toDomain() }.toPersistentList()
    }

    override fun getUsersByCategory(category: Category): PersistentList<ContactUser> {
        return if (category == Category.ALL) {
            getAllUsers()
        } else subUserDao.getUsersByCategory(category).map { it.toDomain() }.toPersistentList()
    }

    override fun deleteUserById(uuid: String) {
        subUserDao.deleteUserByUuid(uuid)
    }

    override fun getUserById(uuid: String): ContactUser {
        return subUserDao.getUserById(uuid).toDomain()
    }
}

private fun ContactUser.toEntity(): SubUserEntity {
    return SubUserEntity(
        uuid = uuid,
        name = name,
        surname = surname,
        email = email,
        phoneNumber = phoneNumber,
        dateOfBirth = dateOfBirth,
        iconImage = iconImage,
        category = category
    )
}
