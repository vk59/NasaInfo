package com.vk59.nasainfo.model


data class Item(
    var data: ItemData,
    var linkForImages: String,
    var links: List<ItemLink>
)