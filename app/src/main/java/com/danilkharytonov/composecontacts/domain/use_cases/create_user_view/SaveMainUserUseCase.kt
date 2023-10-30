package com.danilkharytonov.composecontacts.domain.use_cases.create_user_view

import com.danilkharytonov.composecontacts.domain.model.User
import com.danilkharytonov.composecontacts.domain.repository.MainUserRepository
import com.danilkharytonov.composecontacts.domain.repository.ResourceManager
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserEvent
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserState

class SaveMainUserUseCase(
    private val mainUserRepository: MainUserRepository,
    private val resourceManager: ResourceManager
) : UseCase<CreateUserState, CreateUserEvent> {
    override suspend fun execute(state: CreateUserState, event: CreateUserEvent): CreateUserEvent {
        return if (event is CreateUserEvent.SaveUserEvent) {
            if (state.iconImage.isEmpty()) {
                state.copy(iconImage = resourceManager.createDefaultImageUri().toString())
            }
            val user = User(
                uuid = state.uuid,
                name = state.name,
                surname = state.surname,
                phoneNumber = state.phoneNumber,
                email = state.email,
                dateOfBirth = state.dateOfBirth,
                iconImage = state.iconImage
            )
            mainUserRepository.insertMainUser(user = user)
            resourceManager.setUserCreation()
            CreateUserEvent.UserSaved
        } else CreateUserEvent.Error
    }

    override fun canHandle(event: CreateUserEvent): Boolean {
        return event is CreateUserEvent.SaveUserEvent
    }
}