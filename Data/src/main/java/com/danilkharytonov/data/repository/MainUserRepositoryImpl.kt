package com.danilkharytonov.data.repository

import com.danilkharytonov.data.database.dao.MainUserDao
import com.danilkharytonov.data.database.model.MainUserEntity
import com.danilkharytonov.domain.model.User
import com.danilkharytonov.domain.repository.MainUserRepository

internal class MainUserRepositoryImpl(
    private val mainUserDao: MainUserDao
) : MainUserRepository {
    override suspend fun getMainUser(): User? {
        val entityUser = mainUserDao.getMainUser()
        return if (entityUser != null) {
            User(
                uuid = entityUser.uuid,
                name = entityUser.name,
                surname = entityUser.surname,
                phoneNumber = entityUser.phoneNumber,
                email = entityUser.email,
                dateOfBirth = entityUser.dateOfBirth,
                iconImage = entityUser.iconImage
            )
        } else null
    }

    override suspend fun insertMainUser(user: User) {
        mainUserDao.insertMainUser(user.toEntity())
    }
}

private fun User.toEntity(): MainUserEntity {
    return MainUserEntity(
        name = name,
        surname = surname,
        email = email,
        phoneNumber = phoneNumber,
        dateOfBirth = dateOfBirth,
        iconImage = iconImage
    )
}
