package com.danilkharytonov.composecontacts.di

import com.danilkharytonov.composecontacts.presentation.base.navigation.AppNavigator
import com.danilkharytonov.composecontacts.presentation.base.navigation.Navigator
import org.koin.dsl.module

val appModule = module {
    single<Navigator> {
        AppNavigator()
    }
}