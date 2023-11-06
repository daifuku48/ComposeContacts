package com.danilkharytonov.composecontacts.data.repository

import com.danilkharytonov.composecontacts.data.model.ContactUser
import com.danilkharytonov.composecontacts.data.network.RetrofitInstance
import com.danilkharytonov.composecontacts.data.network.model.toDomain
import com.danilkharytonov.composecontacts.domain.repository.RemoteSubUserRepository

class RemoteSubUserRepositoryImpl(
    private val retrofitInstance: RetrofitInstance
) : RemoteSubUserRepository {
    override suspend fun getUsersFromRemote(): List<ContactUser> {
        return retrofitInstance.getAllUsers(USER_COUNT).userList.map { it.toDomain() }
    }

    companion object {
        const val USER_COUNT = 20
    }
}