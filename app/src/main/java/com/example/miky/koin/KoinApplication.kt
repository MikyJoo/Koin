package com.example.miky.koin

import android.app.Application
import com.example.miky.koin.di.networkModule
import com.example.miky.koin.di.repositoryModule
import com.example.miky.koin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@KoinApplication)
            modules(listOf(
                networkModule,
                repositoryModule,
                viewModelModule
            ))
        }
    }
}