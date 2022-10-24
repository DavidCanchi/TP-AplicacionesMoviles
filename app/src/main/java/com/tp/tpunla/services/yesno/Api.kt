package com.tp.tpunla.services.yesno

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("https://www.yesno.wtf/api?")
    fun getAnswer(@Query("force") answer: String) : Call<YesNo>

}