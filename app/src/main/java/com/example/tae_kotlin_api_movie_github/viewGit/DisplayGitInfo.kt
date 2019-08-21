package com.example.tae_kotlin_api_movie_github.viewGit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tae_kotlin_api_movie_github.Constants
import com.example.tae_kotlin_api_movie_github.R
import com.example.tae_kotlin_api_movie_github.modelGit.RepoModel
import com.example.tae_kotlin_api_movie_github.modelMovie.Results2
import com.example.tae_kotlin_api_movie_github.networkGit.RepoRequest
import com.example.tae_kotlin_api_movie_github.networkMovie.MovieRequest
import com.example.tae_kotlin_api_movie_github.networkMovie.RetrofitInstances
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.diplay_movie_info_page.*
import kotlinx.android.synthetic.main.movie_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayGitInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.git_main_layout)



        val intent = intent
        val id = intent.getIntExtra(ConstantsGit.ID_GIT,0)


//        val id = intent.

        val repoRequest = RetrofitInstances().retrofitInstances.create(RepoRequest::class.java)
        //val call = repoRequest.getRepo(ConstantsGit.ID_GIT,0)

}
}