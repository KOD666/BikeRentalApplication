package com.example.bikerentalapplication.ui.rides

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RidesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Rides Fragment"
    }
    val text: LiveData<String> = _text
}