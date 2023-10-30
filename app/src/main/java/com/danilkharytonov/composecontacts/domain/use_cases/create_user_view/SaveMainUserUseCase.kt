package com.danilkharytonov.composecontacts.domain.use_cases.create_user_view

import com.danilkharytonov.composecontacts.domain.model.User
import com.danilkharytonov.composecontacts.domain.repository.MainUserRepository
import com.danilkharytonov.composecontacts.domain.repository.ResourceManager
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserEvent
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserState
import java.util.regex.Pattern

class SaveMainUserUseCase(
    private val mainUserRepository: MainUserRepository, private val resourceManager: ResourceManager
) : UseCase<CreateUserState, CreateUserEvent> {
    override suspend fun execute(state: CreateUserState, event: CreateUserEvent): CreateUserEvent {
        return if (event is CreateUserEvent.SaveUserEvent) {
            if (isValidState(state)) {
                val user = initUser(state)
                mainUserRepository.insertMainUser(user = user)
                resourceManager.setUserCreation()
                CreateUserEvent.UserSaved
            } else {
                CreateUserEvent.Error
            }
        } else CreateUserEvent.Error
    }

    private fun initUser(state: CreateUserState): User {
        if (state.iconImage.isEmpty())
            return User(
                uuid = state.uuid,
                name = state.name,
                surname = state.surname,
                phoneNumber = state.phoneNumber,
                email = state.email,
                dateOfBirth = state.dateOfBirth,
                iconImage = resourceManager.createDefaultImageUri().toString()
            ) else return User(
            uuid = state.uuid,
            name = state.name,
            surname = state.surname,
            phoneNumber = state.phoneNumber,
            email = state.email,
            dateOfBirth = state.dateOfBirth,
            iconImage = state.iconImage
        )
    }

    override fun canHandle(event: CreateUserEvent): Boolean {
        return event is CreateUserEvent.SaveUserEvent
    }

    private fun isValidState(state: CreateUserState): Boolean {
        val pattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.\\d{4}$")
        return pattern.matcher(state.dateOfBirth).matches()
                || state.name.isNotEmpty()
                || state.email.isNotEmpty()
                || state.phoneNumber.isNotEmpty()
                || state.surname.isNotEmpty()
    }
}