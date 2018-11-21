package com.example.raxabizze.kotlinmvpexample.network

import com.example.raxabizze.kotlinmvpexample.utils.api.pojo.post.Post
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface PostApi {

    @GET
    fun getPosts(@Url url: String): Observable<List<Post>>
}