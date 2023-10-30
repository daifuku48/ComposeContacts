package com.danilkharytonov.composecontacts.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.danilkharytonov.composecontacts.domain.repository.AppRepository

class AppRepositoryImpl(private val context: Context) : AppRepository {
    override fun getSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }

    companion object {
        const val SHARED_PREFERENCES = "SHARED_PREFERENCES"
    }
}