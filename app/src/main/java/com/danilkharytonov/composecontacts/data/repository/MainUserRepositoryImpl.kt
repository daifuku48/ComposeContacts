package com.danilkharytonov.composecontacts.data.repository

import com.danilkharytonov.composecontacts.data.database.MainUserDao
import com.danilkharytonov.composecontacts.data.database.toDomain
import com.danilkharytonov.composecontacts.domain.model.User
import com.danilkharytonov.composecontacts.domain.model.toMainUserEntity
import com.danilkharytonov.composecontacts.domain.repository.MainUserRepository

class MainUserRepositoryImpl(
    private val mainUserDao: MainUserDao
) : MainUserRepository {
    override suspend fun getMainUser(): User {
        return mainUserDao.getMainUser(MAIN_USER_ID).toDomain()
    }

    override suspend fun insertMainUser(user: User) {
        mainUserDao.insertMainUser(user.toMainUserEntity())
    }

    override suspend fun updateMainUser(user: User) {
        mainUserDao.updateMainUser(user.toMainUserEntity())
    }

    companion object {
        const val MAIN_USER_ID = "MAIN_USER_ID"
    }
}