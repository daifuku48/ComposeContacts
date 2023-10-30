package com.danilkharytonov.composecontacts.domain.use_cases.main_user_view

import android.util.Log
import com.danilkharytonov.composecontacts.domain.repository.MainUserRepository
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserEvent
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserState

class GetMainUserUseCase(
    private val repository: MainUserRepository
) : UseCase<MainUserState, MainUserEvent> {
    override suspend fun execute(state: MainUserState, event: MainUserEvent): MainUserEvent {
        return if (event is MainUserEvent.UserLoading) {
            val user = repository.getMainUser()
            if (user == null || user.uuid.isEmpty()) {
                MainUserEvent.Error
            } else MainUserEvent.UserLoaded(user)
        } else {
            MainUserEvent.Error
        }
    }

    override fun canHandle(event: MainUserEvent): Boolean {
        return event is MainUserEvent.UserLoading
    }
}