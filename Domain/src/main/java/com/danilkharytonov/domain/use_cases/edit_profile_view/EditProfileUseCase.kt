package com.danilkharytonov.domain.use_cases.edit_profile_view

import com.danilkharytonov.domain.model.MAIN_USER_ID
import com.danilkharytonov.domain.model.User
import com.danilkharytonov.domain.repository.MainUserRepository
import com.danilkharytonov.domain.repository.ResourceManager
import com.danilkharytonov.domain.use_cases.create_user_view.SaveMainUserUseCase.Companion.MAIN_USER_IMAGE
import java.util.regex.Pattern

class EditProfileUseCase(
    private val mainUserRepository: MainUserRepository,
    private val resourceManager: ResourceManager
) : com.danilkharytonov.core.base.UseCase<EditProfileState, EditProfileEvent> {
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
                        resourceManager.saveUserImage(state.iconImage)
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
        return User(
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
        return email.matches(Regex("^[A-Za-z](.*)(@)(.+)(\\.)(.+)"))
    }

    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        return phoneNumber.isNotEmpty()
    }

    private fun isValidDate(date: String): Boolean {
        val pattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.\\d{4}$")
        return pattern.matcher(date).matches()
    }
}