package com.example.miky.koin.di

import com.example.miky.koin.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
     viewModel { MainViewModel(get()) }
}