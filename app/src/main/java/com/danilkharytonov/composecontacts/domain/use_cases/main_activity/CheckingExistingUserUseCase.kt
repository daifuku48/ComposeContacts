package com.danilkharytonov.composecontacts.domain.use_cases.main_activity

import com.danilkharytonov.composecontacts.data.database.MAIN_USER_ID
import com.danilkharytonov.composecontacts.domain.repository.AppRepository

class CheckingExistingUserUseCase(
    private val appRepository: AppRepository
) {
    fun execute(): Boolean {
        val prefs = appRepository.getSharedPreferences()
        return prefs.getBoolean(MAIN_USER_ID, false)
    }
}