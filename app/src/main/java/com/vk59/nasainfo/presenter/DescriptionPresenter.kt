package com.vk59.nasainfo.presenter

import android.content.Context
import android.content.Intent
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.vk59.nasainfo.view.ExtraConfig
import com.vk59.nasainfo.view.IDescriptionView

@InjectViewState
class DescriptionPresenter : MvpPresenter<IDescriptionView>() {

    fun showData(intent: Intent, applicationContext: Context) {
        val extras = intent.extras
        val title = extras!!.getString(ExtraConfig.TITLE)
        val description = extras!!.getString(ExtraConfig.DESCRIPTION)
        val dateCreate = extras!!.getString(ExtraConfig.DATE_CREATED)
        val linkForImages = extras!!.getString(ExtraConfig.LINK_FOR_IMAGES)

        viewState.showInfo(title, description, dateCreate, linkForImages)
    }

}