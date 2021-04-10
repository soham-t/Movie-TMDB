package com.example.pgp36085

import com.google.gson.annotations.SerializedName

public data class GetTopMoviesResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val pages: Int
)