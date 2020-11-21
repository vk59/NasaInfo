package com.vk59.nasainfo

import android.content.ClipData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vk59.nasainfo.model.Item
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class NasaViewModel : ViewModel(){

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository : NasaRepository = NasaRepository(Apifactory.nasaApi)


    val itemsLiveData = MutableLiveData<MutableList<Item>>()

    fun fetchMovies(){
        scope.launch {
            val popularMovies = repository.getPopularMovies()
            itemsLiveData.postValue(popularMovies)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()

}