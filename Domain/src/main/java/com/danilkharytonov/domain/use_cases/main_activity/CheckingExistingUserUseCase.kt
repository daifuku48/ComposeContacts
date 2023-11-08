package com.danilkharytonov.domain.use_cases.main_activity

import com.danilkharytonov.domain.model.Screen
import com.danilkharytonov.domain.repository.ResourceManager

class CheckingExistingUserUseCase(
    private val resourceManager: ResourceManager
) {
    fun execute(): String {
        return if (resourceManager.checkUserCreation()) {
            Screen.MAIN_USER_SCREEN
        } else Screen.CREATE_USER_SCREEN
    }
}