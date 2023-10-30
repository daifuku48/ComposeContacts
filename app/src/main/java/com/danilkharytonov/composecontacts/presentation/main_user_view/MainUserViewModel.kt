package com.danilkharytonov.composecontacts.presentation.main_user_view

import android.util.Log
import androidx.navigation.NavOptions
import com.danilkharytonov.composecontacts.domain.use_cases.main_user_view.GetMainUserUseCase
import com.danilkharytonov.composecontacts.presentation.base.BaseViewModel
import com.danilkharytonov.composecontacts.presentation.base.Screen.Companion.CREATE_USER_SCREEN
import com.danilkharytonov.composecontacts.presentation.base.Screen.Companion.MAIN_USER_SCREEN
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator

class MainUserViewModel(
    reducer: MainUserReducer,
    useCases: List<GetMainUserUseCase>,
    appNavigator: Navigator
) : BaseViewModel<MainUserEvent, MainUserState>(reducer, useCases, appNavigator) {
    init {
        handleEvent(MainUserEvent.UserLoading)
    }

    fun navigateToCreatingMainUser() {
        Log.d("USER", "USER")
        val navOptions = NavOptions.Builder().setPopUpTo(MAIN_USER_SCREEN, false).build()
        navigate(CREATE_USER_SCREEN, navOptions)
    }

    override fun createInitialState(): MainUserState {
        return MainUserState()
    }
}