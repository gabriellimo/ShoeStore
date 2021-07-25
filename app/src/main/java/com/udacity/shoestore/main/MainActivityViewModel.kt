package com.udacity.shoestore.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainActivityViewModel : ViewModel() {

    private val _list = MutableLiveData<MutableList<Shoe>>()
    val list: LiveData<MutableList<Shoe>>
        get() = _list

    fun addShoe(shoe: Shoe) {
        _list.value?.add(shoe)
    }

    init {
        _list.value = mutableListOf()
    }

}