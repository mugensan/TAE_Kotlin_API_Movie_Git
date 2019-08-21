package com.example.tae_kotlin_api_movie_github.networkGit


import com.example.tae_kotlin_api_movie_github.modelGit.RepoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepoRequest {
    @GET ("users/{user}/repos")

    //this is a list
    fun getRepo(@Path("user") user: String):Call<List<RepoModel>>
}