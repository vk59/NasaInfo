package com.vk59.nasainfo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Meta (
        @SerializedName("total_hits")
        @Expose
        var totalHits: Int
        )
