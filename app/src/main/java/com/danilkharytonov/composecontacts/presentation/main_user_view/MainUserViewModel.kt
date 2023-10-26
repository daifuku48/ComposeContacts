package com.danilkharytonov.composecontacts.presentation.main_user_view

import androidx.navigation.NavOptions
import com.danilkharytonov.composecontacts.domain.model.User
import com.danilkharytonov.composecontacts.domain.use_cases.main_user_view.MainUserUseCase
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.composecontacts.presentation.navigation.Screen.Companion.CREATE_USER_SCREEN
import com.danilkharytonov.composecontacts.presentation.navigation.Screen.Companion.MAIN_USER_SCREEN

class MainUserViewModel(
    reducer: MainUserReducer,
    useCases: List<MainUserUseCase>,
    appNavigator: Navigator
) : BaseViewModel<MainUserEvent, MainUserState>(reducer, useCases, appNavigator) {

    fun navigateToCreatingMainUser(){
        val navOptions = NavOptions.Builder().setPopUpTo(MAIN_USER_SCREEN, false).build()
        navigate(CREATE_USER_SCREEN, navOptions)
    }

    override fun createInitialState(): MainUserState {
        return MainUserState(User(
            uuid = "",
            name = "",
            surname = "",
            phoneNumber = "",
            email = "",
            dateOfBirth = "",
            iconImage = ""
        ))
    }
}