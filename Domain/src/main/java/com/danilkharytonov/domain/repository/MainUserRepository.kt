package com.danilkharytonov.domain.repository

import com.danilkharytonov.domain.model.User

interface MainUserRepository {
    suspend fun getMainUser(): User?
    suspend fun insertMainUser(user: User)
}