package com.example.miky.koin.di

import com.example.miky.koin.data.Joke
import com.example.miky.koin.data.JokeRemoteRepository
import com.example.miky.koin.data.JokeRepository
import com.example.miky.koin.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val repositoryModule = module {

//    factory { (position: Int) -> JokeRepository::getJoke(position) }

    single { JokeRepository(get()) }

    single { JokeRemoteRepository(get()) }
}