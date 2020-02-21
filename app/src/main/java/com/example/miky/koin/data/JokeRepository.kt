package com.example.miky.koin.data

import android.util.Log
import com.example.miky.koin.di.JokeRetrofitService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class JokeRepository (private val remoteSource: JokeRemoteRepository) {

    fun getList(): List<Joke> {
        return remoteSource.jokeList
    }

    fun requestList(callback: (List<Joke>) -> Unit) {
        remoteSource.requestList(callback)
    }
}

class JokeRemoteRepository (private val jokeService: JokeRetrofitService) {
    var jokeList: List<Joke> = ArrayList<Joke>()

    private var disposable = CompositeDisposable()

    fun requestList(callback: (List<Joke>) -> Unit) {
        Log.i("miky", "repository init")

        disposable.add(Observable.just("")
            .subscribeOn(Schedulers.io())
            .switchMap { jokeService.getList().toObservable() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if("success".equals(it.type)) {
                    jokeList = it.value
                    Log.i("miky", "joke list size: ${jokeList.size}")
                    callback(jokeList)
                }
            }, {
                Log.e("miky", it.message ?: "error message null")
            })
        )
    }
}