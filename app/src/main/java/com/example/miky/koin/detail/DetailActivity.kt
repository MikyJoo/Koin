package com.example.miky.koin.detail

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.miky.koin.R
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    val detailViewModel by viewModel<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var idText = findViewById<TextView>(R.id.id_text)
        var jokeText = findViewById<TextView>(R.id.joke_text)

        detailViewModel.joke.observe(this, Observer {
            idText.text = it.id.toString()
            jokeText.text = it.joke
        })

        var position = intent.getIntExtra("position", 0)
        detailViewModel.loadJoke(position)

        jokeText.setOnClickListener {
            detailViewModel.refreshTest()
        }
    }
}