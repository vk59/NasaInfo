package com.vk59.nasainfo.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.vk59.nasainfo.API.APIServiceConstructor
import com.vk59.nasainfo.API.NasaApi
import com.vk59.nasainfo.model.ResponseData
import com.vk59.nasainfo.view.IMainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class MainPresenter: MvpPresenter<IMainView>() {
    private var apiService: NasaApi? = null

    init {
        apiService = APIServiceConstructor.CreateService(NasaApi::class.java)
        loadData()
    }

    private fun loadData() {
        viewState.loading()
        val call: Call<ResponseData?>? = apiService?.getApolloInfo()
        call?.enqueue(object : Callback<ResponseData?> {
            override fun onResponse(
                call: Call<ResponseData?>,
                response: Response<ResponseData?>
            ) {
                if (response.body() != null) {
                    viewState.success(response.body())
                }
            }

            override fun onFailure(
                call: Call<ResponseData?>,
                t: Throwable
            ) {
                viewState.failure()
            }
        })
    }


}