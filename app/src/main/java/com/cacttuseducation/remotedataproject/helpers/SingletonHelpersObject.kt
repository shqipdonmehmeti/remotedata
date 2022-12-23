package com.cacttuseducation.remotedataproject.helpers

import android.content.Context
import android.content.SharedPreferences
import com.cacttuseducation.remotedataproject.api.ServiceAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SingletonHelpersObject {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private const val SHARED_PREFS_NAME = "app_shared_prefs"

    fun provideRetrofitInstance() : ServiceAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ServiceAPI::class.java)
    }

    private fun provideSharedPrefsInstance(context : Context) : SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFS_NAME,Context.MODE_PRIVATE)
    }

    fun putStringOnSharedPrefs(context : Context , key : String , value : String) {
        provideSharedPrefsInstance(context).edit().apply {
            putString(key,value)
            apply()
        }
    }

    fun getStringFromSharedPrefs(context: Context , key : String) : String? {
        return provideSharedPrefsInstance(context).getString(key,"")
    }
}