package com.cacttuseducation.remotedataproject.api

import com.cacttuseducation.remotedataproject.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface ServiceAPI {

    @GET("posts")
    fun getAllPosts() : Call<List<Post>>
}