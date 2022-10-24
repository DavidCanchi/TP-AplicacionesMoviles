package com.tp.tpunla.services.studioghibli

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmDetail(
    var id: String,
    var title: String,
    var image: String,
    var director: String,
    var release_date: String,
    var rt_score: String,
    var original_title_romanised: String,
    var movie_banner: String,
    var description: String,
    var running_time: String
)
