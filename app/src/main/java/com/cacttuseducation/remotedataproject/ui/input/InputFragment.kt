package com.cacttuseducation.remotedataproject.ui.input

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cacttuseducation.remotedataproject.R
import com.cacttuseducation.remotedataproject.databinding.FragmentInputBinding


class InputFragment : Fragment() {
    private lateinit var binding : FragmentInputBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getInputAndNavigateToDetails()
    }

    private fun getInputAndNavigateToDetails() {
        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString()
            val action = InputFragmentDirections.actionInputFragmentToHomeDetailsFragment(name)
            findNavController().navigate(action)
        }
    }


}