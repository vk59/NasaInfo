package com.vk59.nasainfo.presenter

import android.content.Context
import android.content.Intent
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.vk59.nasainfo.API.APIConfig
import com.vk59.nasainfo.API.APIServiceConstructor
import com.vk59.nasainfo.API.ImageAPI
import com.vk59.nasainfo.view.ExtraConfig
import com.vk59.nasainfo.view.IDescriptionView

@InjectViewState
class DescriptionPresenter : MvpPresenter<IDescriptionView>() {

    var apiService: ImageAPI? = null

    init {
        apiService = APIServiceConstructor.CreateService(ImageAPI::class.java, APIConfig.IMAGES_URL)
    }

    fun showData(intent: Intent, applicationContext: Context) {
        val extras = intent.extras
        val title = extras!!.getString(ExtraConfig.TITLE)
        val description = extras!!.getString(ExtraConfig.DESCRIPTION)
        val linkForImages = extras!!.getString(ExtraConfig.LINK_FOR_IMAGES)

        viewState.showInfo(title, description, linkForImages)

//        val call: Call<List<String>?> = apiService?.getImageLinks(linkForImages!!)!!
//        call.enqueue(object : Callback<List<String>?> {
//            override fun onResponse(
//                call: Call<List<String>?>,
//                response: Response<List<String>?>
//            ) {
//                Log.d("PRESENTER", "On Response")
//                val links = response.body()
//            }
//
//            override fun onFailure(
//                call: Call<List<String>?>,
//                t: Throwable
//            ) {
//                Log.d("PRESENTER", "On Failure $t")
//                viewState.failure()
//            }
//        })


    }

}