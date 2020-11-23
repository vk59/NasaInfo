package com.vk59.nasainfo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemData(
    @SerializedName("center")
    @Expose
    var center: String,

    @SerializedName("date_created")
    @Expose
    var dateCreated: String,

    @SerializedName("description")
    @Expose
    var description: String,

    @SerializedName("keywords")
    @Expose
    var keywords: List<String>,

    @SerializedName("media_type")
    @Expose
    var mediaType: String,

    @SerializedName("nasa_id")
    @Expose
    var nasaId: String,

    @SerializedName("title")
    @Expose
    var title: String
) {


}