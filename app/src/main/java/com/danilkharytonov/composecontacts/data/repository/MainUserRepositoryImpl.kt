package com.danilkharytonov.composecontacts.data.repository

import com.danilkharytonov.composecontacts.data.database.MainUserDao
import com.danilkharytonov.composecontacts.data.database.toDomain
import com.danilkharytonov.composecontacts.domain.model.User
import com.danilkharytonov.composecontacts.domain.model.toMainUserEntity
import com.danilkharytonov.composecontacts.domain.repository.MainUserRepository

class MainUserRepositoryImpl(
    private val mainUserDao: MainUserDao
) : MainUserRepository {
    override suspend fun getMainUser(): User? {
        return mainUserDao.getMainUser()?.toDomain()
    }

    override suspend fun insertMainUser(user: User) {
        mainUserDao.insertMainUser(user.toMainUserEntity())
    }
}