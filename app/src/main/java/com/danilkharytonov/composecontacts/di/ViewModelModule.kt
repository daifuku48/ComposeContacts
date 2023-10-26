package com.danilkharytonov.composecontacts.di

import com.danilkharytonov.composecontacts.presentation.base.navigation.AppNavigator
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserReducer
import com.danilkharytonov.composecontacts.presentation.main_user_view.MainUserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory<Navigator> {
        AppNavigator()
    }

    viewModel {
        MainUserViewModel(
            reducer = MainUserReducer(),
            useCases = listOf(get()),
            appNavigator = get()
        )
    }
}