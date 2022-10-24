package com.tp.tpunla.services.studioghibli

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Film(
    var id: String,
    var title: String,
    var image: String,
    var director: String,
    var release_date: String,
    var rt_score: String
    )
