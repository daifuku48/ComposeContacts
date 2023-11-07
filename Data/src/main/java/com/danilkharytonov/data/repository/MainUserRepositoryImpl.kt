package com.danilkharytonov.data.repository

import com.danilkharytonov.data.database.dao.MainUserDao
import com.danilkharytonov.data.database.model.toDomain
import com.danilkharytonov.data.repository.mappers.MapperDomainUserToEntity
import com.danilkharytonov.domain.model.User
import com.danilkharytonov.domain.repository.MainUserRepository

class MainUserRepositoryImpl(
    private val mainUserDao: MainUserDao,
    private val mapperDomainUserToEntity: MapperDomainUserToEntity = MapperDomainUserToEntity()
) : MainUserRepository {
    override suspend fun getMainUser(): User? {
        return mainUserDao.getMainUser()?.toDomain()
    }

    override suspend fun insertMainUser(user: User) {
        mainUserDao.insertMainUser(mapperDomainUserToEntity.map(user))
    }
}