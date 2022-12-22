package com.cacttuseducation.remotedataproject.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cacttuseducation.remotedataproject.api.ServiceAPI
import com.cacttuseducation.remotedataproject.databinding.FragmentHomeBinding
import com.cacttuseducation.remotedataproject.model.Post
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGetAllPosts.setOnClickListener {
            makeApiCalls()
        }

    }

    private fun makeApiCalls() {
        val retrofitInstance = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(ServiceAPI::class.java)


        val getAllPosts = retrofitInstance.getAllPosts()

        getAllPosts.enqueue(object : Callback<List<Post>?> {
            override fun onResponse(call: Call<List<Post>?>, response: Response<List<Post>?>) {
                Log.d("TAG", "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<List<Post>?>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }
        })

    }

}