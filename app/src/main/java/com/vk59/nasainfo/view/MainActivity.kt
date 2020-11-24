package com.vk59.nasainfo.view

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
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
import com.vk59.nasainfo.presenter.MainPresenter
import org.w3c.dom.Text

class MainActivity : MvpAppCompatActivity(), IMainView, NasaAdapter.OnItemNasaListener{

    @InjectPresenter
    internal lateinit var presenter: MainPresenter

    private var refreshLayout: SwipeRefreshLayout? = null
    private var textInfo: TextView? = null
    private var recyclerView: RecyclerView? = null
    private var textTitle: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        textInfo = findViewById(R.id.textInfo)
        refreshLayout = findViewById(R.id.layoutRefresh)

        textTitle = findViewById(R.id.textTitle)
        textTitle!!.setOnClickListener {
            val snackbar: Snackbar = Snackbar.make(
                refreshLayout!!, R.string.info,
                Snackbar.LENGTH_LONG
            )

            snackbar.show()
        }

        refreshLayout!!.setOnRefreshListener(onUpdateListener)

        initRecyclerView()
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
        val snackbar: Snackbar = Snackbar.make(
            refreshLayout!!, R.string.message_failure,
            Snackbar.LENGTH_LONG
        )
        textInfo?.visibility = View.GONE
        snackbar.show()

        Log.d("ACTIVITY", "Is Refreshing = false")

        refreshLayout?.isRefreshing = false
    }

    private val onUpdateListener = SwipeRefreshLayout.OnRefreshListener {
        presenter.loadData()
    }

    override fun onItemNasaClick(position: Int) {
        presenter.showItem(this, position)
    }
}