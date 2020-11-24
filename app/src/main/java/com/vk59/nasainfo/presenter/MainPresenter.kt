package com.vk59.nasainfo.presenter

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.vk59.nasainfo.API.APIConfig
import com.vk59.nasainfo.API.APIServiceConstructor
import com.vk59.nasainfo.API.NasaAPI
import com.vk59.nasainfo.model.Item
import com.vk59.nasainfo.model.ResponseData
import com.vk59.nasainfo.view.DescriptionActivity
import com.vk59.nasainfo.view.ExtraConfig
import com.vk59.nasainfo.view.IMainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class MainPresenter: MvpPresenter<IMainView>() {

    var loadedData: ResponseData? = null

    var apiService: NasaAPI? = null

    init {
        apiService = APIServiceConstructor.CreateService(NasaAPI::class.java, APIConfig.HOST_URL)
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
                    saveResponse(response)
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

    private fun saveResponse(response: Response<ResponseData?>) {
        loadedData = response.body()
    }

    fun showItem(context: Context, position: Int) {
        val intent = Intent(context, DescriptionActivity::class.java)
        val item = loadedData!!.collection.items[position]
        intent.putExtra(ExtraConfig.POSITION, position)
        intent.putExtra(ExtraConfig.TITLE, item.data[0].title)
        intent.putExtra(ExtraConfig.DATE_CREATED, item.data[0].dateCreated)
        intent.putExtra(ExtraConfig.DESCRIPTION, item.data[0].description)
        intent.putExtra(ExtraConfig.LINK_FOR_IMAGES, item.links[0].link)
        context.startActivity(intent)
    }
}
