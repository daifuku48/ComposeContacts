package com.danilkharytonov.composecontacts.data.repository

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import androidx.core.content.edit
import com.danilkharytonov.composecontacts.R
import com.danilkharytonov.composecontacts.data.database.MAIN_USER_ID
import com.danilkharytonov.composecontacts.domain.repository.ResourceManager

class ResourceManagerImpl(
    private val context: Context
) : ResourceManager {

    private val sharedPreferences by lazy {
        context.applicationContext.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }

    override fun checkUserCreation(): Boolean {
        return sharedPreferences.getBoolean(MAIN_USER_ID, false)
    }

    override fun setUserCreation() {
        sharedPreferences.edit {
            putBoolean(MAIN_USER_ID, true)
        }
    }

    override fun createDefaultImageUri(): Uri {
        val defaultImageResourceId = R.drawable.baseline_person_24
        return Uri.Builder()
            .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
            .authority(
                context.applicationContext.resources?.getResourceTypeName(defaultImageResourceId)
            )
            .appendPath(
                context.applicationContext.resources?.getResourceTypeName(defaultImageResourceId)
            )
            .appendPath(
                context.applicationContext.resources?.getResourceEntryName(defaultImageResourceId)
            )
            .build()
    }

    companion object {
        const val SHARED_PREFERENCES = "SHARED_PREFERENCES"
        const val STORAGE_PERMISSION_CODE = 1
    }
}