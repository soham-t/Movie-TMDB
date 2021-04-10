package com.example.pgp36085

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop

class MoviesAdapter(
    private var movies: List<Movie>
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }
    override fun getItemCount(): Int = movies.size
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun updateMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val poster: CardView = itemView.findViewById(R.id.cards)
        private val context: Context = itemView.context
        fun bind(movie: Movie) {
            Glide.with(itemView)
                    .load("https://image.tmdb.org/t/p/w342${movie.posterPath}")
                    .transform(CenterCrop())
                    .into(poster.findViewById(R.id.item_movie_poster))
            val name: TextView = poster.findViewById(R.id.movie_name)
            name.text = movie.title
            val image: ImageView = poster.findViewById(R.id.item_movie_poster)
            image.setOnClickListener {
                val i:Intent = Intent(context,AuxActivity::class.java)
                i.putExtra("name",movies[adapterPosition].title)
                i.putExtra("description",movies[adapterPosition].overview)
                i.putExtra("release",movies[adapterPosition].releaseDate)
                i.putExtra("rating",movies[adapterPosition].rating.toString())
                context.startActivity(i)
            }
            /*val myClickListener: View.OnClickListener = View.OnClickListener {
                fun onClick(v:View){
                    if(v == image){
                        Toast.makeText(context,"Click Successful", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            image.setOnClickListener(myClickListener)*/
        }
    }
}