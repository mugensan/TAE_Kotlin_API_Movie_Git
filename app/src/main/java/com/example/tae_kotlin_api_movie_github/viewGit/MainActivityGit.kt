package com.example.tae_kotlin_api_movie_github.viewGit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.tae_kotlin_api_github.model.RepoModel
//import com.example.tae_kotlin_api_github.network.RepoRequest
//import com.example.tae_kotlin_api_github.network.RetrofitInstanceGit
import com.example.tae_kotlin_api_movie_github.R
import com.example.tae_kotlin_api_movie_github.modelGit.RepoModel
import com.example.tae_kotlin_api_movie_github.modelMovie.Results
import com.example.tae_kotlin_api_movie_github.networkGit.RepoRequest
import com.example.tae_kotlin_api_movie_github.networkGit.RetrofitInstanceGit
import com.example.tae_kotlin_api_movie_github.viewMovie.MovieAdapter
import kotlinx.android.synthetic.main.movie_main_activity.rv_data_display
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityGit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_main_activity)

        val repoRequest = RetrofitInstanceGit().retrofitInstances.create(RepoRequest::class.java)

        val call = repoRequest.getRepo(ConstantsGit.user)

        call.enqueue(object : Callback<List<RepoModel>> {
            override fun onFailure(call: Call<List<RepoModel>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<RepoModel>>, response: Response<List<RepoModel>>) {
                val res = response.body()

                Log.d("MAINACTIVITY", res!![0].name)

                rv_data_display.layoutManager = LinearLayoutManager(this@MainActivityGit)
                rv_data_display.adapter = GitAdapter(res)
            }
        })
        //connecting the rv_ with the adapter


    }
}



