package com.example.miky.koin.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Joke(
    var id: Int = 0,
    var joke: String = ""
) : Parcelable

data class GetListResult(
    var type: String,
    var value: List<Joke>
)