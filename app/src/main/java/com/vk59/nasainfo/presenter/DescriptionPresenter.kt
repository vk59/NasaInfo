package com.vk59.nasainfo.presenter

import android.content.Intent
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.vk59.nasainfo.view.ExtraConfig
import com.vk59.nasainfo.view.IDescriptionView

@InjectViewState
class DescriptionPresenter: MvpPresenter<IDescriptionView>() {
    fun showData(intent: Intent) {
        val extras = intent.extras
        val title = extras!!.getString(ExtraConfig.TITLE)
        val description = extras!!.getString(ExtraConfig.DESCRIPTION)
        val linkForImages = extras!!.getString(ExtraConfig.LINK_FOR_IMAGES)
        viewState.showInfo(title, description, linkForImages)
    }

}