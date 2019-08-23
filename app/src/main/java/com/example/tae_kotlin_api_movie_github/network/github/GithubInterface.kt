package com.example.tae_kotlin_api_movie_github.network.github


import com.example.tae_kotlin_api_movie_github.model.RepoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubInterface {
    @GET ("users/{user}/repos")

    //this is a list
    fun getRepo(@Path("user") user: String):Call<List<RepoModel>>
}