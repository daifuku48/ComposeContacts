package com.danilkharytonov.composecontacts.di

import com.danilkharytonov.composecontacts.data.repository.MainUserRepositoryImpl
import com.danilkharytonov.composecontacts.data.repository.RemoteSubUserRepositoryImpl
import com.danilkharytonov.composecontacts.data.repository.ResourceManagerImpl
import com.danilkharytonov.composecontacts.data.repository.SubUserRepositoryLocalImpl
import com.danilkharytonov.composecontacts.domain.repository.MainUserRepository
import com.danilkharytonov.composecontacts.domain.repository.RemoteSubUserRepository
import com.danilkharytonov.composecontacts.domain.repository.ResourceManager
import com.danilkharytonov.composecontacts.domain.repository.SubUserLocalRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<ResourceManager> {
        ResourceManagerImpl(get())
    }

    factory<MainUserRepository> {
        MainUserRepositoryImpl(get())
    }

    factory<SubUserLocalRepository> {
        SubUserRepositoryLocalImpl(get())
    }

    factory<RemoteSubUserRepository> {
        RemoteSubUserRepositoryImpl(get())
    }
}