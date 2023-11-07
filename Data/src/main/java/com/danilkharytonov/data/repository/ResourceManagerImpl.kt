package com.danilkharytonov.data.repository

import android.content.Context
import android.util.Log
import androidx.core.content.edit
import androidx.core.net.toUri
import com.danilkharytonov.domain.model.MAIN_USER_ID
import com.danilkharytonov.domain.repository.ResourceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

internal class ResourceManagerImpl(
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

    override suspend fun saveUserImage(uri: String) {
        withContext(Dispatchers.IO) {
            try {
                val dir = context.filesDir
                val imageFile = File(dir, MAIN_USER_IMAGE)

                if (!imageFile.exists()) {
                    try {
                        imageFile.createNewFile()
                    } catch (e: Exception) {
                        Log.e("Failed to create file", e.stackTraceToString())
                    }
                }

                val input = context.contentResolver.openInputStream(uri.toUri())
                val output = FileOutputStream(imageFile)

                input?.use { inputStream ->
                    output.use { outputStream ->
                        inputStream.copyTo(outputStream)
                    }
                }
                uri
            } catch (e: Exception) {
                Log.e("Failed to save image", e.stackTraceToString())
                uri
            }
        }
    }

    companion object {
        const val SHARED_PREFERENCES = "SHARED_PREFERENCES"
        const val MAIN_USER_IMAGE = "main_user_icon.jpg"
    }
}