package com.vk59.nasainfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    private var nasaViewModel: NasaViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nasaViewModel = ViewModelProviders.of(this).get(NasaViewModel::class.java)

        nasaViewModel!!.fetchMovies()

        nasaViewModel!!.itemsLiveData.observe(this, Observer {

            //TODO - Your Update UI Logic
        })

    }
}