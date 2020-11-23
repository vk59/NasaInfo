package com.vk59.nasainfo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("data")
    @Expose(deserialize = false, serialize = false)
    var data: List<ItemData>,

    @SerializedName("href")
    @Expose
    var linkForImages: String,

    @SerializedName("links")
    @Expose
    var links: List<ItemLink>
)