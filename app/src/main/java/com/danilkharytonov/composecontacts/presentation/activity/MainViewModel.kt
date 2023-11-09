package com.danilkharytonov.composecontacts.presentation.activity

import androidx.lifecycle.ViewModel
import com.danilkharytonov.domain.use_cases.main_activity.CheckingExistingUserUseCase

class MainViewModel(
    private val checkingExistingUserUseCase: CheckingExistingUserUseCase
) : ViewModel() {
    fun getDestination(): String {
        return checkingExistingUserUseCase.execute()
    }
}