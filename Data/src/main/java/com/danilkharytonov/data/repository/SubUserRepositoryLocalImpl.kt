package com.danilkharytonov.data.repository

import com.danilkharytonov.data.database.dao.SubUserDao
import com.danilkharytonov.data.database.model.toDomain
import com.danilkharytonov.data.repository.mappers.MapperDomainContactUserToEntity
import com.danilkharytonov.domain.model.Category
import com.danilkharytonov.domain.model.ContactUser
import com.danilkharytonov.domain.repository.SubUserLocalRepository
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

class SubUserRepositoryLocalImpl(
    private val subUserDao: SubUserDao,
    private val mapperDomainContactUserToEntity: MapperDomainContactUserToEntity = MapperDomainContactUserToEntity()
) : SubUserLocalRepository {
    override fun insertUser(user: ContactUser) {
        subUserDao.insertUser(mapperDomainContactUserToEntity.map(user))
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