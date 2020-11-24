package com.vk59.nasainfo.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vk59.nasainfo.R
import com.vk59.nasainfo.model.Item

class NasaAdapter(private val items: List<Item>, private val onItemNasaListener: OnItemNasaListener) :
        RecyclerView.Adapter<NasaAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.nasa_info_item, parent, false)
        return MyViewHolder(itemView, onItemNasaListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = items[position].data[0]
        val description = data.description
        val length: Int = minimum(40, description.length)

        holder.textTitle!!.text = data.title
        holder.textDescription!!.text = "${description.substring(0, length)}..."

        if (items[position].links != null) {
        Picasso.get()
            .load(items[position].links[0].link)
            .fit()
            .into(holder.imagePreview)
        }
    }

    private fun minimum(num1: Int, num2: Int): Int = if (num1 < num2) num1 else num2

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(itemView: View, onItemNasaListener: OnItemNasaListener) : RecyclerView.ViewHolder(itemView) {
        var textTitle: TextView? = null
        var textDescription: TextView? = null
        var imagePreview: ImageView? = null

        init {
            textTitle = itemView.findViewById(R.id.textTitle)
            textDescription = itemView.findViewById(R.id.textDescription)
            imagePreview = itemView.findViewById(R.id.imagePreview)

            itemView.setOnClickListener {
                val position = adapterPosition
                onItemNasaListener.onItemNasaClick(position)
            }
        }
    }

    interface OnItemNasaListener {
        fun onItemNasaClick(position: Int)
    }
}