package com.example.miky.koin.di

import com.example.miky.koin.data.GetListResult
import io.reactivex.Single
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.icndb.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokeRetrofitService::class.java)
    }
}

interface JokeRetrofitService {
    @GET("jokes/random/20")
    fun getList(): Single<GetListResult>
}