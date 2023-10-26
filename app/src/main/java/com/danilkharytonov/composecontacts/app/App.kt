package com.danilkharytonov.composecontacts.app

import android.app.Application
import com.danilkharytonov.composecontacts.di.databaseModule
import com.danilkharytonov.composecontacts.di.domainModule
import com.danilkharytonov.composecontacts.di.repositoryModule
import com.danilkharytonov.composecontacts.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(
                databaseModule,
                domainModule,
                repositoryModule,
                viewModelModule
            ))
        }
    }
}