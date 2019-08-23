package com.example.tae_kotlin_api_movie_github.view.github

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tae_kotlin_api_movie_github.R
import com.example.tae_kotlin_api_movie_github.network.github.GithubInterface
import com.example.tae_kotlin_api_movie_github.network.movie.MovieRetrofitInstance


class GithubDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.git_main_layout)


//
        val intent = intent
        val id = intent.getIntExtra(ConstantsGit.ID_GIT,0)
        val repoRequest = MovieRetrofitInstance().retrofitInstances.create(
            GithubInterface::class.java)




//        call.enqueue {
//            onResponse = {
//                    dominoes ->  val res = dominoes.body()
//            }
//            onFailure = {
//                    error -> Log.d("Fail", error.message)
//            }
//        }

}
}