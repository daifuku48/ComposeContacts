package com.danilkharytonov.composecontacts.di

import com.danilkharytonov.composecontacts.domain.use_cases.main_activity.CheckingExistingUserUseCase
import com.danilkharytonov.composecontacts.presentation.activity.MainActivityReducer
import com.danilkharytonov.composecontacts.presentation.activity.MainViewModel
import com.danilkharytonov.composecontacts.presentation.base.navigation.AppNavigator
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserReducer
import com.danilkharytonov.composecontacts.presentation.create_user_view.CreateUserViewModel
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserReducer
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainUserViewModel(
            reducer = MainUserReducer(),
            useCases = listOf(get()),
            appNavigator = get()
        )
    }

    viewModel {
        CreateUserViewModel(
            reducer = CreateUserReducer(),
            useCases = listOf(get()),
            appNavigator = get()
        )
    }

    viewModel {
        MainViewModel(
            reducer = MainActivityReducer(),
            useCases = listOf(get()),
            appNavigator = get()
        )
    }
}