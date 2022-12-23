package com.cacttuseducation.remotedataproject.ui.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cacttuseducation.remotedataproject.databinding.FragmentDataBinding
import com.cacttuseducation.remotedataproject.helpers.SingletonHelpersObject.getStringFromSharedPrefs
import com.cacttuseducation.remotedataproject.helpers.SingletonHelpersObject.putStringOnSharedPrefs


class DataFragment : Fragment() {
    private lateinit var binding: FragmentDataBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBtnClick()
    }

    private fun onBtnClick() {
        binding.btnSaveHobby.setOnClickListener {
            val hobbyValue = binding.etHobby.text.toString()
            putStringOnSharedPrefs(requireContext(), "hobby", hobbyValue)
        }

        binding.btnGetHobby.setOnClickListener {
            val hobbyFromSharedPrefs = getStringFromSharedPrefs(requireContext(), "hobby")
            binding.tvShowHobby.text = hobbyFromSharedPrefs
        }
    }


}