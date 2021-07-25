package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable {
                    fun isFulfilled(): Boolean = (name.isNotBlank() && size != 0.0 && company.isNotBlank() && description.isNotBlank())
                }