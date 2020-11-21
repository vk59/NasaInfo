package com.vk59.nasainfo

import com.vk59.nasainfo.model.Item

class NasaRepository(private val api : NasaApi) : BaseRepository() {

    suspend fun getPopularMovies() : MutableList<Item>?{

        val responseData = safeApiCall(
            call = {api.getApollo().await()},
            errorMessage = "Error Fetching Popular Movies"
        )

        return responseData?.items!!.toMutableList()

    }

}