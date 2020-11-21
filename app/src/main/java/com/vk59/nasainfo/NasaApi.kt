package com.vk59.nasainfo

import com.vk59.nasainfo.model.ResponseData
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface NasaApi {
    // perhaps Response isn't suitable
    @GET("search?q=apollo%2011...")
    fun getApollo() : Deferred<Response<ResponseData>>
}