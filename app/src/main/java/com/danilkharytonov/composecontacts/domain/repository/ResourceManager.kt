package com.danilkharytonov.composecontacts.domain.repository

import android.net.Uri

interface ResourceManager {
    fun checkUserCreation() : Boolean
    fun setUserCreation()
    fun createDefaultImageUri() : Uri
}