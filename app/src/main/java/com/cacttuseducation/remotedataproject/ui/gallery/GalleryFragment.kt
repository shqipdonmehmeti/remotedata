package com.cacttuseducation.remotedataproject.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cacttuseducation.remotedataproject.databinding.FragmentGalleryBinding
import com.cacttuseducation.remotedataproject.helpers.SingletonHelpersObject
import com.cacttuseducation.remotedataproject.helpers.SingletonHelpersObject.provideRetrofitInstance
import com.cacttuseducation.remotedataproject.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGetOnePost.setOnClickListener {
            makeApiCalls()

        }
    }

    private fun makeApiCalls() {
        val getOnePost = provideRetrofitInstance().getOnePost(2)

        getOnePost.enqueue(object : Callback<Post?> {
            override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                binding.tvShowOnePost.text = response.body().toString()

            }

            override fun onFailure(call: Call<Post?>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }
        })
    }

}