package com.example.tae_kotlin_api_movie_github.view.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tae_kotlin_api_movie_github.common.Constants
//import com.example.tae_kotlin_api.Constants
//import com.example.tae_kotlin_api.R
//import com.example.tae_kotlin_api.model.MoviePopular
//import com.example.tae_kotlin_api.model.Results
//import com.example.tae_kotlin_api.model.Results2
import com.example.tae_kotlin_api_movie_github.network.movie.MovieInterface
import com.example.tae_kotlin_api_movie_github.network.movie.MovieRetrofitInstance
import com.example.tae_kotlin_api_movie_github.R
import com.example.tae_kotlin_api_movie_github.common.enqueue

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diplay_movie_info_page)

        val intent = intent
        val id = intent.getIntExtra(Constants.ID,0)


//        val id = intent.

        val movieRequest = MovieRetrofitInstance()
            .retrofitInstances.create(MovieInterface::class.java)
        val call = movieRequest.GetMovieDetails(id, Constants.API_KEY_MOVIE)

        call.enqueue {
            onResponse = {
                    retroMovie ->  val res = retroMovie.body()

            }
            onFailure = {
                    failure ->
                if (failure != null) {
                    Log.d("Retrofit failure", failure.message)
                }
            }



//        call.enqueue(object : Callback<Results2> {
//            override fun onFailure(call: Call<Results2>, t: Throwable) {
//            }
//
//
//
//            override fun onResponse(call: Call<Results2>, response: Response<Results2>) {
//                val res = response.body()
//                Log.d("SECONDACTIVITY",res!!.title )
//                tv_title2.text = res.title
//                tv_overview.text = res.overview
//                rt_bar.rating = res.vote_average.toFloat()
//                Picasso.get().load("https://image.tmdb.org/t/p/w185" + res.poster_path).into(img_view)
//                tv_vote_avg!!.text = res.vote_average.toString() + "/10"
//
//                }




        }

    }
}


