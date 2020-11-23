package com.vk59.nasainfo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemLink(
    @SerializedName("href")
    @Expose
    var link: String,

    @SerializedName("render")
    @Expose
    var type: String
)