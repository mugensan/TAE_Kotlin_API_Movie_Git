package com.example.tae_kotlin_api_movie_github.PrimaryActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tae_kotlin_api_movie_github.R
import com.example.tae_kotlin_api_movie_github.common.showToast
import com.example.tae_kotlin_api_movie_github.common.sort
//import com.example.tae_kotlin_api_movie_github.common.toast
import com.example.tae_kotlin_api_movie_github.view.github.GithubActivity
import com.example.tae_kotlin_api_movie_github.view.movie.MovieActivity
import kotlinx.android.synthetic.main.activity_main.*

class PrimaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    btn_go_to_movie.setOnClickListener {
        val intent= Intent(this,
            MovieActivity::class.java)
        showToast(this,"you clicked movie")
        val list = arrayListOf(5, 4, 2, 8, 1)
            .sort()
        for(i in 0 until list.size)

            Log.d("array", list[i].toString())


        startActivity(intent)
//

    }

        btn_go_to_github.setOnClickListener {
            val intent = Intent(this, GithubActivity::class.java)
            showToast(this,"you clicked git")
            startActivity(intent)
        }




    }
}
