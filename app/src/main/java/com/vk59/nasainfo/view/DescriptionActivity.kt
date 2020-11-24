package com.vk59.nasainfo.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import com.vk59.nasainfo.R
import com.vk59.nasainfo.presenter.DescriptionPresenter
import com.vk59.nasainfo.presenter.DescriptionView

class DescriptionActivity : MvpAppCompatActivity(), DescriptionView {
    @InjectPresenter
    internal lateinit var presenter: DescriptionPresenter

    private var constraintLayout: ConstraintLayout? = null

    private var textDescriptionInfo: TextView? = null
    private var textTitleInfo: TextView? = null
    private var textDateCreated: TextView? = null
    private var imageDescription: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        initActivity()
        presenter.showData(intent)
    }

    private fun initActivity() {
        constraintLayout = findViewById(R.id.constraintLayout)
        textDescriptionInfo = findViewById(R.id.textDescriptionInfo)
        textTitleInfo = findViewById(R.id.textTitleInfo)
        textDateCreated = findViewById(R.id.textDate)
        imageDescription = findViewById(R.id.imageDescription)
    }

    override fun showInfo(title: String?, description: String?, date: String?, link: String?) {
        textDescriptionInfo!!.text = "DESCRIPTION:\n $description"
        textTitleInfo!!.text = title
        textDateCreated!!.text = "DATE CREATED: $date"
        Picasso.get()
            .load(link)
            .placeholder(R.drawable.nasa)
            .into(imageDescription)
    }
}

