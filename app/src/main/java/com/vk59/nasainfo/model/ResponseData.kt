package com.vk59.nasainfo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("collection")
    @Expose
    var collection: Data
)