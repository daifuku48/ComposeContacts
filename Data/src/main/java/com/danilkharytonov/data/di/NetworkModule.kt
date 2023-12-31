package com.danilkharytonov.data.di

import com.danilkharytonov.data.network.RetrofitInstance
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    factory {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(RetrofitInstance.BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<RetrofitInstance> {
        get<Retrofit>().create(RetrofitInstance::class.java)
    }
}