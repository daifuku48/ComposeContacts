package com.danilkharytonov.composecontacts.domain.use_cases.edit_profile

import android.util.Patterns
import androidx.core.net.toUri
import com.danilkharytonov.composecontacts.data.database.model.MAIN_USER_ID
import com.danilkharytonov.composecontacts.data.repository.ResourceManagerImpl.Companion.MAIN_USER_IMAGE
import com.danilkharytonov.composecontacts.domain.model.User
import com.danilkharytonov.composecontacts.domain.repository.MainUserRepository
import com.danilkharytonov.composecontacts.domain.repository.ResourceManager
import com.danilkharytonov.composecontacts.presentation.base.UseCase
import com.danilkharytonov.composecontacts.presentation.edit_profile_screen.EditProfileEvent
import com.danilkharytonov.composecontacts.presentation.edit_profile_screen.EditProfileState
import java.util.regex.Pattern

class EditProfileUseCase(
    private val mainUserRepository: MainUserRepository,
    private val resourceManager: ResourceManager
) : UseCase<EditProfileState, EditProfileEvent> {
    override suspend fun execute(
        state: EditProfileState,
        event: EditProfileEvent
    ): EditProfileEvent {
        return when (event) {
            is EditProfileEvent.SaveEditingUser -> {
                if (isValidDate(state.date) && isValidName(state.name) && isValidEmail(state.email) && isValidName(
                        state.surname
                    ) &&
                    isValidPhoneNumber(state.phoneNumber)
                ) {
                    val user = initUser(state)
                    mainUserRepository.insertMainUser(user = user)
                    if (state.iconImage != MAIN_USER_IMAGE) {
                        resourceManager.saveUserImage(state.iconImage.toUri())
                    }
                    EditProfileEvent.EditingUserSavedEvent
                } else EditProfileEvent.ErrorEvent
            }

            is EditProfileEvent.GetMainUserEvent -> {
                val user = mainUserRepository.getMainUser()
                if (user != null) {
                    EditProfileEvent.MainUserIsReceivedEvent(
                        name = user.name,
                        surname = user.surname,
                        phone = user.phoneNumber,
                        email = user.email,
                        birth = user.dateOfBirth,
                        imageIcon = user.iconImage
                    )
                } else EditProfileEvent.ErrorEvent
            }

            else -> {
                EditProfileEvent.ErrorEvent
            }
        }
    }

    private fun initUser(state: EditProfileState): User {
        if (state.iconImage.isEmpty())
            return User(
                uuid = MAIN_USER_ID,
                name = state.name,
                surname = state.surname,
                phoneNumber = state.phoneNumber,
                email = state.email,
                dateOfBirth = state.date,
                iconImage = resourceManager.createDefaultImageUri().toString()
            ) else return User(
            uuid = MAIN_USER_ID,
            name = state.name,
            surname = state.surname,
            phoneNumber = state.phoneNumber,
            email = state.email,
            dateOfBirth = state.date,
            iconImage = MAIN_USER_IMAGE
        )
    }

    override fun canHandle(event: EditProfileEvent): Boolean {
        return event is EditProfileEvent.SaveEditingUser || event is EditProfileEvent.GetMainUserEvent
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