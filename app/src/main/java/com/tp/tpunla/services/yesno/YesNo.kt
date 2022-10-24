package com.tp.tpunla.services.yesno

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class YesNo(
    val answer: String,
    val forced: Boolean,
    val image: String
)
