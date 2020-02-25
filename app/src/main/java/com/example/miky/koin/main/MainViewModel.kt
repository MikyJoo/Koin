package com.example.miky.koin.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.miky.koin.data.Joke
import com.example.miky.koin.data.JokeRepository

class MainViewModel(private val jokeRepository: JokeRepository): ViewModel() {

    var jokeListLiveData = jokeRepository.getLiveDataForList()

    init {
        Log.i("miky", "Main view model init")
        jokeListLiveData.value = ArrayList<Joke>()
        refreshList()
    }

    fun refreshList() {
        jokeRepository.requestList {
            Log.i("miky", "get joke list is success")
            jokeListLiveData = it
        }
    }

    fun onClickItem(position: Int) {

    }

    fun getList(): ArrayList<Joke> {
        return jokeListLiveData.value!!
    }
}