package com.danilkharytonov.composecontacts.domain.use_cases.create_user_view

import android.util.Patterns
import androidx.core.net.toUri
import com.danilkharytonov.composecontacts.data.repository.ResourceManagerImpl.Companion.MAIN_USER_IMAGE
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
            if (isValidDate(state.dateOfBirth) && isValidName(state.name) && isValidEmail(state.email) && isValidName(
                    state.surname
                ) &&
                isValidPhoneNumber(state.phoneNumber)
            ) {
                val user = initUser(state)
                mainUserRepository.insertMainUser(user = user)
                resourceManager.setUserCreation()
                resourceManager.saveUserImage(state.iconImage.toUri())
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
            iconImage = MAIN_USER_IMAGE
        )
    }

    override fun canHandle(event: CreateUserEvent): Boolean {
        return event is CreateUserEvent.SaveUserEvent
    }

    private fun isValidName(name: String): Boolean {
        return name.isNotEmpty() && name.matches(Regex("^[A-Za-z ]+\$"))
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = Patterns.EMAIL_ADDRESS
        return emailPattern.matcher(email).matches()
    }

    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        return phoneNumber.isNotEmpty()
    }

    private fun isValidDate(date: String): Boolean {
        val pattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.\\d{4}$")
        return pattern.matcher(date).matches()
    }
}