package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail,container, false)

        binding.cancelButton.setOnClickListener { v: View ->
            v.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment_cancel)
        }

        binding.submitButton.setOnClickListener { v: View ->
            v.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment_submit)
        }

        return binding.root
    }

}