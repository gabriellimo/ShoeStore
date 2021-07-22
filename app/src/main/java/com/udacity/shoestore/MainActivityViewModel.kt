package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainActivityViewModel : ViewModel() {

    private val _list = MutableLiveData<MutableList<Shoe>>()
    val list: LiveData<MutableList<Shoe>>
        get() = _list

    fun addShoe(name: String, company: String, size: Double, description: String) {
        val shoe = Shoe(name, size, company, description)
        _list.value?.add(shoe)
    }

    init {
        val list2 = listOf(
            Shoe("shox", 42.0, "nike", "foi")
        ) as MutableList<Shoe>
        _list.value = list2
    }

}