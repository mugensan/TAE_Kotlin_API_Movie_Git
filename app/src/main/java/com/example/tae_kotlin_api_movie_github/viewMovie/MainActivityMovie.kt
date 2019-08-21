package com.example.tae_kotlin_api_movie_github.viewMovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tae_kotlin_api_movie_github.Constants
//import com.example.tae_kotlin_api.Constants
//import com.example.tae_kotlin_api.R
//import com.example.tae_kotlin_api.model.MoviePopular
//import com.example.tae_kotlin_api.model.Results
import com.example.tae_kotlin_api_movie_github.networkMovie.MovieRequest
import com.example.tae_kotlin_api_movie_github.networkMovie.RetrofitInstances
import com.example.tae_kotlin_api_movie_github.R
import com.example.tae_kotlin_api_movie_github.modelMovie.MoviePopular
import com.example.tae_kotlin_api_movie_github.modelMovie.Results
import kotlinx.android.synthetic.main.movie_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityMovie : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_main_activity)

        //calling the retrofitInstance (interface), to be used like an Intent of some sort
        val MovieRequest = RetrofitInstances().retrofitInstances.create(MovieRequest::class.java)

        //need to create the call
        val call = MovieRequest.getMoviesPopular(ConstantsMovie.API_KEY_MOVIE)

        //creating the enqueue
        call.enqueue(object : Callback<MoviePopular> {
            override fun onFailure(call: Call<MoviePopular>, t: Throwable) {

            }

            override fun onResponse(call: Call<MoviePopular>, response: Response<MoviePopular>) {
                val res = response.body()

                //!!. == none null()
                Log.d("MAINACTIVITY", res!!.results[0].title)
//                Log.d("MAINACTIVITY", res.results[10].overview)

                //this is how we set the recyclerView
                rv_data_display.layoutManager = LinearLayoutManager(this@MainActivityMovie)

                //connecting the rv_ with the adapter
                //this is one way
                val adapter: MovieAdapter = MovieAdapter(res, object : OnMovieClickListener {


                    override fun onMovieClickListener(result: Results) {
                        Log.d("CLICKED_ITEM", result.title)
                        var intent = Intent(this@MainActivityMovie, DisplayMovieInfo::class.java)
                        intent.putExtra(Constants.ID, result.id)
                        startActivity(intent)



                        sendToNextActivity()
                        //if you have different fun
                        //do your intentSatart()
                        //~~~~~~~~~~~~~~~~~~~~~~~~~~~
                        //TODO(START DETAIL ACTIVITY, PARSE THE ID, NEW RETROFIT CALL --> THEN DISPLAY DATA)

                    }


                })
                //connecting the rv_ with the adapter
                rv_data_display.adapter = adapter


            }
        })
    }

    fun sendToNextActivity() {


    }
}


//    }
//    //so if you had dif fun
//    fun startFuntion(){
//        Intent intent = Intent
//        intentPutExtra()
//        startActivity()
////    }


//}
