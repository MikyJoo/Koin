package com.example.miky.koin.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.miky.koin.data.Joke
import com.example.miky.koin.data.JokeRepository

class DetailViewModel(private val jokeRepository: JokeRepository): ViewModel() {

    var joke = MutableLiveData<Joke>()

    fun loadJoke(position: Int) {
        joke.value = jokeRepository.getJoke(position)
    }

    fun refreshTest() {
        Log.i("miky", "refresh Test")
        jokeRepository.requestList {
            Log.i("miky", "requestList success")
        }
    }

}