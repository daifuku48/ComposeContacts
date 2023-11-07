package com.danilkharytonov.composecontacts.di

import com.danilkharytonov.data.repository.MainUserRepositoryImpl
import com.danilkharytonov.data.repository.RemoteSubUserRepositoryImpl
import com.danilkharytonov.data.repository.ResourceManagerImpl
import com.danilkharytonov.data.repository.SubUserRepositoryLocalImpl
import com.danilkharytonov.domain.repository.MainUserRepository
import com.danilkharytonov.domain.repository.RemoteSubUserRepository
import com.danilkharytonov.domain.repository.ResourceManager
import com.danilkharytonov.domain.repository.SubUserLocalRepository
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