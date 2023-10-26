package com.danilkharytonov.composecontacts.di

import com.danilkharytonov.composecontacts.data.repository.MainUserRepositoryImpl
import com.danilkharytonov.composecontacts.domain.repository.MainUserRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<MainUserRepository> {
        MainUserRepositoryImpl(get())
    }
}