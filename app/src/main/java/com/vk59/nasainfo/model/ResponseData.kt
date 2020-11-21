package com.vk59.nasainfo.model

data class ResponseData (
    var currentLink: String,
    var items: List<Item>,
    var navigationLinks: List<NavigationLink>
)