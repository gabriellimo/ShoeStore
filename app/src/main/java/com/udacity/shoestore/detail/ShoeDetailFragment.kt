package com.udacity.shoestore.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.main.MainActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()

    private lateinit var detailViewModelFactory: ShoeDetailViewModelFactory
    private lateinit var detailViewModel: ShoeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        detailViewModelFactory = ShoeDetailViewModelFactory(viewModel)
        detailViewModel = ViewModelProvider(this, detailViewModelFactory).get(ShoeDetailViewModel::class.java)

        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_detail,container, false)

        binding.viewModel = detailViewModel
        binding.lifecycleOwner = this

        detailViewModel.eventBackToList.observe(viewLifecycleOwner, { backToList ->

            if(backToList) {
                findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
                detailViewModel.backToListComplete()
            }

        })

        detailViewModel.eventSubmitNotFulfilled.observe(viewLifecycleOwner, { submitNotFulfilled ->

            if(submitNotFulfilled) {
                Toast.makeText(this.activity, "You must fulfill all fields", Toast.LENGTH_SHORT).show()
                detailViewModel.eventSubmitNotFulfilledComplete()
            }

        })


        return binding.root
    }

}