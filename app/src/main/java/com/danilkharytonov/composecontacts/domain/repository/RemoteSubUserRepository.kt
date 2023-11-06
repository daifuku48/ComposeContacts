package com.danilkharytonov.composecontacts.domain.repository

import com.danilkharytonov.composecontacts.data.model.ContactUser

interface RemoteSubUserRepository {
    suspend fun getUsersFromRemote(): List<ContactUser>
}