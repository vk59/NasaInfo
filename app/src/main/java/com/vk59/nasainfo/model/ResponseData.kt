package com.vk59.nasainfo.model

import com.google.gson.annotations.SerializedName

data class ResponseData (
    @SerializedName("href")
    var currentLink: String,

    @SerializedName("items")
    var items: List<Item>,

    @SerializedName("links")
    var navigationLinks: List<NavigationLink>
)