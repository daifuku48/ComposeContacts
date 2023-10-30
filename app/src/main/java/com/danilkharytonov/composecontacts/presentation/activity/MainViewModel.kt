package com.danilkharytonov.composecontacts.presentation.activity

import androidx.lifecycle.ViewModel
import com.danilkharytonov.composecontacts.domain.use_cases.main_activity.CheckingExistingUserUseCase
import com.danilkharytonov.composecontacts.presentation.base.Screen

class MainViewModel(
    private val checkingExistingUserUseCase: CheckingExistingUserUseCase
) : ViewModel() {
    fun getDestination(): String {
        return if (checkingExistingUserUseCase.execute()) {
            Screen.MAIN_USER_SCREEN
        } else Screen.CREATE_USER_SCREEN
    }
}