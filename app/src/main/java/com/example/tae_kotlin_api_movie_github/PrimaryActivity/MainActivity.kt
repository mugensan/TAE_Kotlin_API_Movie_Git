package com.example.tae_kotlin_api_movie_github.PrimaryActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tae_kotlin_api_movie_github.R
import com.example.tae_kotlin_api_movie_github.viewGit.MainActivityGit
import com.example.tae_kotlin_api_movie_github.viewMovie.MainActivityMovie
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    btn_go_to_movie.setOnClickListener {
        val intent= Intent(this,MainActivityMovie::class.java)
        startActivity(intent)
    }

        btn_go_to_github.setOnClickListener {
            val intent = Intent(this,MainActivityGit::class.java)
            startActivity(intent)
        }


    }
}
