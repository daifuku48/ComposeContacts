package com.danilkharytonov.composecontacts.di

import com.danilkharytonov.composecontacts.domain.use_cases.main_user_view.MainUserUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        MainUserUseCase(get())
    }
}