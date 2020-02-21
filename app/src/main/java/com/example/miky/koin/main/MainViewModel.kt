package com.example.miky.koin.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miky.koin.data.Joke
import com.example.miky.koin.data.JokeRepository

class MainViewModel(private val jokeRepository: JokeRepository): ViewModel() {

    var jokeListLiveData = MutableLiveData<List<Joke>>()

    init {
        Log.i("miky", "Main view model init")
        refreshList()
    }

    fun refreshList() {
        jokeRepository.requestList {
            Log.i("miky", "get joke list is success")
            jokeListLiveData.value = it
        }
    }
}