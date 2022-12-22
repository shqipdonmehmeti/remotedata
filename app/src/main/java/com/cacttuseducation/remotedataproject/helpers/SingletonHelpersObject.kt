package com.cacttuseducation.remotedataproject.helpers

import com.cacttuseducation.remotedataproject.api.ServiceAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SingletonHelpersObject {
    fun provideRetrofitInstance() : ServiceAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(ServiceAPI::class.java)
    }
}