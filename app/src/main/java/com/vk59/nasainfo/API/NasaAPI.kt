package com.vk59.nasainfo.API

import com.vk59.nasainfo.model.ResponseData
import retrofit2.Call
import retrofit2.http.GET

interface NasaAPI {
    @GET("search?q=apollo%2011&media_type=image")
    fun getApolloInfo(): Call<ResponseData?>
}