package com.cacttuseducation.remotedataproject.api

import com.cacttuseducation.remotedataproject.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceAPI {
    @GET("posts")
    fun getAllPosts() : Call<List<Post>>

    @GET("posts/{id}")
    fun getOnePost(@Path("id") ourId : Int) : Call<Post>
}