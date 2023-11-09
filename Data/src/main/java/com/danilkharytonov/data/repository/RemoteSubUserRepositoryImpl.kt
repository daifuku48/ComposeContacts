package com.danilkharytonov.data.repository

import com.danilkharytonov.data.network.RetrofitInstance
import com.danilkharytonov.domain.model.ContactUser
import com.danilkharytonov.domain.repository.RemoteSubUserRepository

internal class RemoteSubUserRepositoryImpl(
    private val retrofitInstance: RetrofitInstance
) : RemoteSubUserRepository {
    override suspend fun getUsersFromRemote(): List<ContactUser> {
        return retrofitInstance.getAllUsers(USER_COUNT).userList.map { it.toDomain() }
    }

    companion object {
        const val USER_COUNT = 20
    }
}