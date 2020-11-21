package com.vk59.nasainfo.model

data class ItemData(
    var center: String,
    var dateCreated: String,
    var description: String,
    var keywords: List<String>,
    var mediaType: String,
    var nasaId: String,
    var title: String
) {


}