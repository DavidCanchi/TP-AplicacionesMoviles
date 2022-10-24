package com.tp.tpunla.services.studioghibli

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("/films?fields=id,title,director,rt_score,image,release_date")
    fun getFilms(@Query("limit") limit: Int) : Call<List<Film>>

    @GET("/films/{id}")
    fun getFilm(@Path("id") id: String) : Call<FilmDetail>
}