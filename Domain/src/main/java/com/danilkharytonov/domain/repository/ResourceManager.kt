package com.danilkharytonov.domain.repository

interface ResourceManager {
    fun checkUserCreation(): Boolean
    fun setUserCreation()
    suspend fun saveUserImage(uri: String)
}