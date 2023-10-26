package com.danilkharytonov.composecontacts.domain.use_cases.main_user_view

import com.danilkharytonov.composecontacts.domain.repository.MainUserRepository
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserEvent
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserState

class MainUserUseCase(
    private val repository: MainUserRepository
) : UseCase<MainUserState, MainUserEvent> {
    override suspend fun execute(state: MainUserState, event: MainUserEvent): MainUserEvent {
        return if (event is MainUserEvent.UserLoaded) {
            MainUserEvent.UserLoaded(repository.getMainUser())
        } else {
            MainUserEvent.Error
        }
    }

    override fun canHandle(event: MainUserEvent): Boolean {
        return event is MainUserEvent.UserLoaded
    }
}