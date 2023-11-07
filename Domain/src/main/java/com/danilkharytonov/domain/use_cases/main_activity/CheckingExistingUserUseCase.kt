package com.danilkharytonov.domain.use_cases.main_activity

import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.domain.repository.ResourceManager

class CheckingExistingUserUseCase(
    private val resourceManager: ResourceManager
) : UseCase<MainActivityState, MainActivityEvent> {
    override suspend fun execute(
        state: MainActivityState, event: MainActivityEvent
    ): MainActivityEvent {
        return if (event is MainActivityEvent.CheckExistingUser) {
            if (resourceManager.checkUserCreation()) {
                MainActivityEvent.UserIsExist
            } else MainActivityEvent.UserIsNotExist
        } else MainActivityEvent.UserIsNotExist
    }

    override fun canHandle(event: MainActivityEvent): Boolean {
        return event is MainActivityEvent.CheckExistingUser
    }
}