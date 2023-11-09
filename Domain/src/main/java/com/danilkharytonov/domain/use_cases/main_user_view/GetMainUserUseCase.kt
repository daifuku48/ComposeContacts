package com.danilkharytonov.domain.use_cases.main_user_view


import com.danilkharytonov.core.base.UseCase
import com.danilkharytonov.domain.repository.MainUserRepository

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