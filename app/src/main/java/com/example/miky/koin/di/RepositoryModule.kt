package com.example.miky.koin.di

import com.example.miky.koin.data.JokeRemoteRepository
import com.example.miky.koin.data.JokeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { JokeRepository(get()) }

    single { JokeRemoteRepository(get()) }
}