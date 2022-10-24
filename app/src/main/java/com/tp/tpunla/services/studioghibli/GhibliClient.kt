package com.tp.tpunla.services.studioghibli

import com.tp.tpunla.services.RetrofitClient

object GhibliClient {

    val api = RetrofitClient.client.create(Api::class.java)
}