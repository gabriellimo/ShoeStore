package com.udacity.shoestore.detail

import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.main.MainActivityViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel(private val mainViewModel: MainActivityViewModel) : ViewModel() {

    //  I'm not sure this is a good solution. Keeping references between two ViewModel's may be a problema,
    //  but some of the logic didn't make much sense to be kept in a "global" ViewModel, such as the MainActivityViewModel
    //  One reference to the MainActivityViewModel was still needed, since I must update the list, which is used in two different fragments
    //  I think I can avoid some memory leak keeping this shoe variable in this variable, which only makes sense in ShoeDetailFragment
    //  It's also a good way to encapsulate responsibilities and to practice the ViewModelFactory pattern usage

    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
        get() = _shoe

    private val _eventBackToList = MutableLiveData<Boolean>(false)
    val eventBackToList: LiveData<Boolean>
        get() = _eventBackToList

    private val _eventSubmitNotFulfilled = MutableLiveData<Boolean>(false)
    val eventSubmitNotFulfilled: LiveData<Boolean>
        get() = _eventSubmitNotFulfilled

    init {
        _shoe.value = Shoe("",0.0,"","")
    }

    fun onSubmitClick() {
        //android studio forced me to inset the "== true". Not sure why. Something to do with the nullability of shoe.value
        // how is it possible to get something different from Boolean as a result of isFullFilled?

        if (shoe.value?.isFulfilled() == true) {
            //shoe will not be nullable, as long as I keep the init block as it is
            mainViewModel.addShoe(shoe.value!!)
            backToList()
        }
        else {
            _eventSubmitNotFulfilled.value = true
        }
    }

    fun onCancelClick() {
        backToList()
    }

    private fun backToList() {
        _eventBackToList.value = true
    }

    fun backToListComplete() {
        _eventBackToList.value = false
    }

    fun eventSubmitNotFulfilledComplete() {
        _eventSubmitNotFulfilled.value = false
    }

    companion object Converter {
        @InverseMethod("toDouble")
        fun toString(size: Double): String {
            //keep it empty if not filled
            if (size == 0.0) return ""
            return size.toString()
        }

        fun toDouble(size: String): Double {
            return size.toDouble()
        }
    }

}