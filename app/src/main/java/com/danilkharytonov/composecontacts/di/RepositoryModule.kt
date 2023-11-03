package com.danilkharytonov.composecontacts.di

import com.danilkharytonov.composecontacts.data.repository.MainUserRepositoryImpl
import com.danilkharytonov.composecontacts.data.repository.ResourceManagerImpl
import com.danilkharytonov.composecontacts.data.repository.SubUserRepositoryImpl
import com.danilkharytonov.composecontacts.domain.repository.MainUserRepository
import com.danilkharytonov.composecontacts.domain.repository.ResourceManager
import com.danilkharytonov.composecontacts.domain.repository.SubUserRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<ResourceManager> {
        ResourceManagerImpl(get())
    }

    factory<MainUserRepository> {
        MainUserRepositoryImpl(get())
    }

    factory<SubUserRepository> {
        SubUserRepositoryImpl(get())
    }
}