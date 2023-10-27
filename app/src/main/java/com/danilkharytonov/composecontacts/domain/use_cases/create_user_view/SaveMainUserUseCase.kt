package com.danilkharytonov.composecontacts.domain.use_cases.create_user_view

import com.danilkharytonov.composecontacts.domain.repository.MainUserRepository
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserEvent
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserState

class SaveMainUserUseCase(
    private val repository: MainUserRepository
) : UseCase<CreateUserState, CreateUserEvent> {
    override suspend fun execute(state: CreateUserState, event: CreateUserEvent): CreateUserEvent {
        return if (event is CreateUserEvent.SaveUserEvent) {
            repository.insertMainUser(user = state.savedUser)
            CreateUserEvent.UserSaved
        } else CreateUserEvent.Error
    }

    override fun canHandle(event: CreateUserEvent): Boolean {
        return event is CreateUserEvent.SaveUserEvent
    }
}