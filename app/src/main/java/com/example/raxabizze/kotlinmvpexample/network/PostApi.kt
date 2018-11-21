package com.example.raxabizze.kotlinmvpexample.network

import com.example.raxabizze.kotlinmvpexample.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}