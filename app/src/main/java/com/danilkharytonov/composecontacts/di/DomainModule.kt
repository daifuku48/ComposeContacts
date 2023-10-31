package com.danilkharytonov.composecontacts.di

import com.danilkharytonov.composecontacts.domain.use_cases.create_user_view.SaveMainUserUseCase
import com.danilkharytonov.composecontacts.domain.use_cases.main_activity.CheckingExistingUserUseCase
import com.danilkharytonov.composecontacts.domain.use_cases.main_user_view.GetMainUserUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetMainUserUseCase(get())
    }

    factory {
        SaveMainUserUseCase(get(), get())
    }

    factory {
        CheckingExistingUserUseCase(
            get()
        )
    }
}