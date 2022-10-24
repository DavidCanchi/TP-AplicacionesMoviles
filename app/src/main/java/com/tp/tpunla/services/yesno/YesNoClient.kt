package com.tp.tpunla.services.yesno

import com.tp.tpunla.services.RetrofitClient

object YesNoClient {
    val api = RetrofitClient.client.create(Api::class.java)
}