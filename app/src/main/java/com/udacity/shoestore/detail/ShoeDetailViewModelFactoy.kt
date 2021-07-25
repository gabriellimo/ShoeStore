package com.udacity.shoestore.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.main.MainActivityViewModel

class ShoeDetailViewModelFactory(private val activityViewModel: MainActivityViewModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeDetailViewModel::class.java)) {
            return ShoeDetailViewModel(activityViewModel) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}