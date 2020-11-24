package com.vk59.nasainfo.view

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.vk59.nasainfo.R
import com.vk59.nasainfo.presenter.DescriptionPresenter
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

class DescriptionActivity : MvpAppCompatActivity(), IDescriptionView {

    @InjectPresenter
    internal lateinit var presenter: DescriptionPresenter

    private var textDescriptionInfo: TextView? = null
    private var textTitleInfo: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        textDescriptionInfo = findViewById(R.id.textDescriptionInfo)
        textTitleInfo = findViewById(R.id.textTitleInfo)

        presenter.showData(intent)
    }

    override fun showInfo(title: String?, description: String?, linksForImages: String?) {
        Log.d("DESCRIPTION ACTIVITY", "Des: $description")
        textDescriptionInfo!!.text = description
        textTitleInfo!!.text= title

    }
}