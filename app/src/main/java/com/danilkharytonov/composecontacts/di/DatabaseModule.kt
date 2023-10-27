package com.danilkharytonov.composecontacts.di

import androidx.room.Room
import com.danilkharytonov.composecontacts.data.database.UserDatabase
import org.koin.dsl.module

val databaseModule = module {
    factory {
        Room.databaseBuilder(
            context = get(),
            klass = UserDatabase::class.java,
            name = "user_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<UserDatabase>().getMainUserDao()
    }
}