package com.vk59.nasainfo.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class NavigationLink(
        @SerializedName("prompt")
        @Expose
        val prompt: String,

        @SerializedName("href")
        @Expose
        val href: String,

        @SerializedName("rel")
        @Expose
        val rel: String
)