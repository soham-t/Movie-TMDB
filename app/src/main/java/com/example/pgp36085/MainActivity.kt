package com.example.pgp36085

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var topratedMovies: RecyclerView
    private lateinit var topratedMoviesAdapter: MoviesAdapter
    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMoviesAdapter: MoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        topratedMovies = findViewById(R.id.top_rated)
        topratedMovies.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        popularMovies = findViewById(R.id.popular_movies)
        popularMovies.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        topratedMoviesAdapter = MoviesAdapter(listOf())
        topratedMovies.adapter = topratedMoviesAdapter

        MoviesRepository.getTopMovies(
            onSuccess =  ::onTopMoviesFetched,
            onError = ::onError
        )
        popularMoviesAdapter = MoviesAdapter(listOf())
        popularMovies.adapter = popularMoviesAdapter

        MoviesRepository.getPopularMovies(
            onSuccess = ::onPopularMoviesFetched,
            onError = ::onError
        )
    }

    private fun onTopMoviesFetched(movies: List<Movie>) {
        topratedMoviesAdapter.updateMovies(movies)
    }
    private fun onPopularMoviesFetched(movies: List<Movie>) {
        popularMoviesAdapter.updateMovies(movies)
    }

    private fun onError() {
        Toast.makeText(this, getString(R.string.error_fetch_movies), Toast.LENGTH_SHORT).show()
    }
}