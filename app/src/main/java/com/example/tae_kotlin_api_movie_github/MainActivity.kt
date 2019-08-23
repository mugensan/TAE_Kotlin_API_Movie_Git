package com.example.tae_kotlin_api_movie_github

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tae_kotlin_api_movie_github.view.github.GithubActivity
import com.example.tae_kotlin_api_movie_github.view.movie.MovieActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn_go_to_github.setOnClickListener {
            val intent = Intent(this, GithubActivity::class.java)
            startActivity(intent)

        }

        btn_go_to_movie.setOnClickListener {
            val intent = Intent (this, MovieActivity::class.java)
            startActivity(intent)
        }
    }
}
//
//    }
//}