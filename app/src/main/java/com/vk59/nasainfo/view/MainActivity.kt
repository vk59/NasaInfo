package com.vk59.nasainfo.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.google.android.material.snackbar.Snackbar
import com.vk59.nasainfo.R
import com.vk59.nasainfo.model.Item
import com.vk59.nasainfo.presenter.MainView
import com.vk59.nasainfo.presenter.MainPresenter
import com.vk59.nasainfo.presenter.NasaAdapter

class MainActivity : MvpAppCompatActivity(), MainView, NasaAdapter.OnItemNasaListener {
    @InjectPresenter
    internal lateinit var presenter: MainPresenter

    private var refreshLayout: SwipeRefreshLayout? = null
    private var textInfo: TextView? = null
    private var recyclerView: RecyclerView? = null
    private var textTitle: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initActivity()

        initRecyclerView()
    }

    private fun initActivity() {
        textInfo = findViewById(R.id.textInfo)
        refreshLayout = findViewById(R.id.layoutRefresh)

        textTitle = findViewById(R.id.textTitle)
        textTitle!!.setOnClickListener {
            Snackbar.make(
                refreshLayout!!, R.string.info,
                Snackbar.LENGTH_LONG
            ).show()
        }

        refreshLayout!!.setOnRefreshListener(onUpdateListener)
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }

    override fun loading() {
        refreshLayout?.isRefreshing = true
    }

    override fun success(data: List<Item>) {
        recyclerView!!.adapter = NasaAdapter(data, this)
        textInfo?.visibility = View.GONE
        refreshLayout?.isRefreshing = false
    }

    override fun failure() {
        Snackbar.make(
            refreshLayout!!, R.string.message_failure,
            Snackbar.LENGTH_LONG
        ).show()
        textInfo?.visibility = View.GONE

        refreshLayout?.isRefreshing = false
    }

    private val onUpdateListener = SwipeRefreshLayout.OnRefreshListener {
        presenter.loadData()
    }

    override fun onItemNasaClick(position: Int) {
        presenter.showItem(this, position)
    }
}