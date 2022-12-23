package com.cacttuseducation.remotedataproject.ui.home_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cacttuseducation.remotedataproject.R
import com.cacttuseducation.remotedataproject.databinding.FragmentHomeDetailsBinding


class HomeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentHomeDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments?.getString("name")
        Toast.makeText(context,"My name is $name",Toast.LENGTH_LONG).show()
    }


}