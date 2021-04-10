package com.example.pgp36085


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "8237516e033bd50d25c4d433fb77ba65",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    @GET("movie/top_rated")
    fun getTopMovies(
        @Query("api_key") apiKey: String = "8237516e033bd50d25c4d433fb77ba65",
        @Query("page") page: Int
    ): Call<GetTopMoviesResponse>
}