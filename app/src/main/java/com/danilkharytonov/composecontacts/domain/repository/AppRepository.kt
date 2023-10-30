package com.danilkharytonov.composecontacts.domain.repository

import android.content.SharedPreferences

interface AppRepository {
    fun getSharedPreferences(): SharedPreferences
}