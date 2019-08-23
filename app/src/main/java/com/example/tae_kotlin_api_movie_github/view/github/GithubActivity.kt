package com.example.tae_kotlin_api_movie_github.view.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tae_kotlin_api_movie_github.R
import com.example.tae_kotlin_api_movie_github.model.RepoModel
import com.example.tae_kotlin_api_movie_github.network.github.GithubInterface
import com.example.tae_kotlin_api_movie_github.network.github.GithubRetrofitInstance
import com.example.tae_kotlin_api_movie_github.network.movie.MovieRetrofitInstance
import kotlinx.android.synthetic.main.movie_main_activity.rv_data_display
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GithubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_main_activity)

        val repoRequest = GithubRetrofitInstance()
            .retrofitInstances.create(
            GithubInterface::class.java)

        val call = repoRequest.getRepo(ConstantsGit.user)




//        call.enqueue {
//            onResponse = {
//                retroGit -> val res = retroGit.body()
//                val adapter = GitAdapter(res!!,onGitClickListener{
//                    override fun onGitClickListener(result:Results){
//                        Log.d("CLICKED_GIT_ITEM",result.title )
//                    }
//                })
//                rv_data_display.layoutManager = LinearLayoutManager(this@GithubActivity)
//                rv_data_display.adapter = GitAdapter(res!!, onGitClickListener{
////                    override fun onGitClickListener(result:Results){
////                        Log.d("CLICKED_GIT_ITEM",result.title )
////                    }
//                })
//            }
//            onFailure = {
//                    failure ->
//                if(failure != null){
//                    Log.d("Retrofit failure", failure.message)
//                }
//            }
//        }
//        call.enqueue {
//            onResponse = {
//                    dominoes ->  val res = dominoes.body()
//            }
//            onFailure = {
//                    error -> Log.d("Fail", error.message)
//            }
//        }


        call.enqueue(object : Callback<List<RepoModel>> {
            override fun onFailure(call: Call<List<RepoModel>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<RepoModel>>, response: Response<List<RepoModel>>) {
                val res = response.body()

                Log.d("MAINACTIVITY", res!![0].name)

                rv_data_display.layoutManager = LinearLayoutManager(this@GithubActivity)
                rv_data_display.adapter =
                    GitAdapter(
                        res!!,
                        repoRequest
                    )
            }
        })
        //connecting the rv_ with the adapter


    }
}



