package com.danilkharytonov.composecontacts.domain.repository

import com.danilkharytonov.composecontacts.domain.model.User

interface MainUserRepository {
    suspend fun getMainUser(): User?
    suspend fun insertMainUser(user: User)
}