package com.danilkharytonov.composecontacts.domain.use_cases.create_user_view

import androidx.core.content.edit
import com.danilkharytonov.composecontacts.data.database.MAIN_USER_ID
import com.danilkharytonov.composecontacts.domain.repository.AppRepository
import com.danilkharytonov.composecontacts.domain.repository.MainUserRepository
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserEvent
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserState

class SaveMainUserUseCase(
    private val mainUserRepository: MainUserRepository,
    private val appRepository: AppRepository
) : UseCase<CreateUserState, CreateUserEvent> {
    override suspend fun execute(state: CreateUserState, event: CreateUserEvent): CreateUserEvent {
        return if (event is CreateUserEvent.SaveUserEvent) {
            mainUserRepository.insertMainUser(user = state.savedUser)
            appRepository.getSharedPreferences().edit {
                putBoolean(MAIN_USER_ID, true)
            }
            CreateUserEvent.UserSaved
        } else CreateUserEvent.Error
    }

    override fun canHandle(event: CreateUserEvent): Boolean {
        return event is CreateUserEvent.SaveUserEvent
    }
}