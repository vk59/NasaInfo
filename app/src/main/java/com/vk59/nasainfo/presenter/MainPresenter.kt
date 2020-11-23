package com.vk59.nasainfo.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.vk59.nasainfo.API.APIServiceConstructor
import com.vk59.nasainfo.API.NasaAPI
import com.vk59.nasainfo.model.ResponseData
import com.vk59.nasainfo.view.IMainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class MainPresenter: MvpPresenter<IMainView>() {
    var apiService: NasaAPI? = null

    init {
        apiService = APIServiceConstructor.CreateService(NasaAPI::class.java)
        loadData()
    }

    fun loadData() {
        Log.d("PRESENTER", "Started data loading")

        viewState.loading()
        val call: Call<ResponseData?> = apiService?.getApolloInfo()!!
        call.enqueue(object : Callback<ResponseData?> {
            override fun onResponse(
                    call: Call<ResponseData?>,
                    response: Response<ResponseData?>
            ) {
                Log.d("PRESENTER", "On Response")
                if (response.body() != null) {
                    viewState.success(response.body()!!.collection.items)
                    Log.d("PRESENTER", "Response body is not null. Success")
                }
            }

            override fun onFailure(
                    call: Call<ResponseData?>,
                    t: Throwable
            ) {
                Log.d("PRESENTER", "On Failure $t")
                viewState.failure()
            }
        })
    }
}