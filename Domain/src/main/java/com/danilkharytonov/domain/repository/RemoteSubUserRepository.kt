package com.danilkharytonov.domain.repository

import com.danilkharytonov.domain.model.ContactUser

interface RemoteSubUserRepository {
    suspend fun getUsersFromRemote(): List<ContactUser>
}