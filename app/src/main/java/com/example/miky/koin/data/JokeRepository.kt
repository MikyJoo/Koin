package com.example.miky.koin.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.miky.koin.di.JokeRetrofitService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.text.FieldPosition

class JokeRepository (private val remoteSource: JokeRemoteRepository) {

    fun getLiveDataForList(): MutableLiveData<ArrayList<Joke>> {
        return remoteSource.jokeList
    }

    fun requestList(callback: (MutableLiveData<ArrayList<Joke>>) -> Unit) {
        remoteSource.requestList(callback)
    }

    fun getJoke(position: Int): Joke? {
        return remoteSource.jokeList.value?.get(position) ?:null
    }
}

class JokeRemoteRepository (private val jokeService: JokeRetrofitService) {
    var jokeList: MutableLiveData<ArrayList<Joke>> = MutableLiveData<ArrayList<Joke>>()

    private var disposable = CompositeDisposable()

    fun requestList(callback: (MutableLiveData<ArrayList<Joke>>) -> Unit) {
        Log.i("miky", "repository init")

        disposable.add(Observable.just("")
            .subscribeOn(Schedulers.io())
            .switchMap { jokeService.getList().toObservable() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if("success".equals(it.type)) {
                    Log.i("miky", "joke list size: ${it.value.size}")
                    jokeList.value = it.value
                    callback(jokeList)
                }
            }, {
                Log.e("miky", it.message ?: "error message null")
            })
        )
    }
}