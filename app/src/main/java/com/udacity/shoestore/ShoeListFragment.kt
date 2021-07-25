package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.main.MainActivityViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list,container, false)
        viewModel.list.observe(viewLifecycleOwner, Observer { list ->

            populateListLayout(list)

        })

        binding.fab.setOnClickListener { v: View ->
            v.findNavController().navigate(R.id.shoeListFragment_to_shoeDetailFragment)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                logout()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun logout() {
        findNavController().navigate(R.id.logout)
    }

    private fun populateListLayout(list: List<Shoe>) {

        for (shoe in list)
        {
            val layoutInflater = LayoutInflater.from(this.activity)
            val itemBinding = ShoeListItemBinding.inflate(layoutInflater,binding.shoeList, false)
            itemBinding.shoesText.text = shoe.company + "-" + shoe.name
            itemBinding.shoesDescriptionText.text = shoe.description
            itemBinding.shoesSizeText.text = shoe.size.toString()
            binding.shoeList.addView(itemBinding.root)

        }
    }

}