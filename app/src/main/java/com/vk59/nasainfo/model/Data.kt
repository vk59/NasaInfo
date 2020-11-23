package com.vk59.nasainfo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
        @SerializedName("version")
        @Expose
        val version: String,

        @SerializedName("metadata")
        @Expose
        val metadata: Meta,

        @SerializedName("href")
        @Expose
        val href: String,

        @SerializedName("items")
        @Expose
        val items: List<Item>,

        @SerializedName("links")
        @Expose
        val links: List<ItemLink>
) {

}