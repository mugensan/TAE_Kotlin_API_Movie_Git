package com.example.tae_kotlin_api_movie_github.view.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.tae_kotlin_api.Constants
//import com.example.tae_kotlin_api.R
//import com.example.tae_kotlin_api.model.MoviePopular
//import com.example.tae_kotlin_api.model.Results
import com.example.tae_kotlin_api_movie_github.network.movie.MovieInterface
import com.example.tae_kotlin_api_movie_github.network.movie.MovieRetrofitInstance
import com.example.tae_kotlin_api_movie_github.R
import com.example.tae_kotlin_api_movie_github.common.enqueue
import com.example.tae_kotlin_api_movie_github.model.movie.Results
import kotlinx.android.synthetic.main.movie_layout.*

class MovieActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_main_activity)


        //calling the retrofitInstance (interface), to be used like an Intent of some sort
        val MovieRequest = MovieRetrofitInstance()
            .retrofitInstances.create(MovieInterface::class.java)

        //need to create the call
        val call = MovieRequest.getMoviesPopular(MovieContants.API_KEY_MOVIE)

        //creating the enqueue
        call.enqueue {
            onResponse = { retroMovie ->
                val res = retroMovie.body()
                val adapter = MovieAdapter(res!!,
                    object :
                        OnMovieClickListener {
                        override fun onMovieClickListener(result: Results) {
                            Log.d("CLICKED_ITEM", result.title)
                        }
                    })
                //this is how we set the recyclerView
                rv_data_display.layoutManager = LinearLayoutManager(this@MovieActivity)
                rv_data_display.adapter = adapter
                //connecting the rv_ with the adapter
                //this is one way
//                val adapter = MovieAdapter(res, object : OnMovieClickListener {

            }
            onFailure = { failure ->
                if (failure != null) {
                    Log.d("Retrofit failure", failure.message)
                }
            }
        }
    }
}



