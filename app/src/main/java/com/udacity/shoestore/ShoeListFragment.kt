package com.udacity.shoestore

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var bindingListItem: ShoeListItemBinding
    private lateinit var itemLayout: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list,container, false)
        viewModel.list.observe(viewLifecycleOwner, Observer { list ->

            populateListLayout(list)

        })

        binding.fab.setOnClickListener { v: View ->
            v.findNavController().navigate(R.id.shoeListFragment_to_shoeDetailFragment)
        }

        return binding.root
    }

    private fun populateListLayout(list: List<Shoe>) {

        for (shoe in list)
        {
        }
    }

}