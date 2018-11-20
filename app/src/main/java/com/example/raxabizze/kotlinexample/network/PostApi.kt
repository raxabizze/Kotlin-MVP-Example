package com.example.raxabizze.kotlinexample.network

import com.example.raxabizze.kotlinexample.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}