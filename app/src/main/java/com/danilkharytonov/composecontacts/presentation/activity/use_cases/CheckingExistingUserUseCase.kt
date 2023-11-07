package com.danilkharytonov.composecontacts.presentation.activity.use_cases

import com.danilkharytonov.domain.repository.ResourceManager
import com.danilkharytonov.composecontacts.presentation.activity.MainActivityEvent
import com.danilkharytonov.composecontacts.presentation.activity.MainActivityState
import com.danilkharytonov.core.base.UseCase

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