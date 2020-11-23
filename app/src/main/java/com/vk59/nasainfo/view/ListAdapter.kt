package com.vk59.nasainfo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vk59.nasainfo.R
import com.vk59.nasainfo.model.Item

class ListAdapter(private val items: List<Item>) :
        RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.nasa_info_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textTitle!!.text = items[position].data[0].title
        val description = items[position].data[0].description
        val length: Int = minimum(40, description.length)
        holder.textDescription!!.text = "${description.substring(0, length)}..."
    }

    private fun minimum(num1: Int, num2: Int): Int = if (num1 < num2) num1 else num2

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textTitle: TextView? = null
        var textDescription: TextView? = null

        init {
            textTitle = itemView?.findViewById(R.id.textTitle)
            textDescription = itemView?.findViewById(R.id.textDescription)
        }
    }
}