package com.danilkharytonov.composecontacts.di

import com.danilkharytonov.core.base.navigation.AppNavigator
import com.danilkharytonov.core.base.navigation.Navigator
import org.koin.dsl.module

val appModule = module {
    single<Navigator> {
        AppNavigator()
    }
}