package com.vk59.nasainfo.view

import android.os.Bundle
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.vk59.nasainfo.R
import com.vk59.nasainfo.model.ResponseData
import com.vk59.nasainfo.presenter.MainPresenter

class MainActivity : MvpAppCompatActivity(){

    @InjectPresenter
    var presenter: MainPresenter? = null

    private var refreshLayout: SwipeRefreshLayout? = null
    private var textInfo: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        var textView: TextView = findViewById(R.id.textView)
    }

    override fun loading() {
        TODO("Not yet implemented")
    }

    override fun success(data: ResponseData?) {
        TODO("Not yet implemented")
    }

    override fun failure() {
        TODO("Not yet implemented")
    }
}