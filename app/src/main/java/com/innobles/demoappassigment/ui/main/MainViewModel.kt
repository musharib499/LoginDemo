package com.innobles.demoappassigment.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var confirmPassword = MutableLiveData<String>()





}