package com.suitmedia.palindromeapp.ui.firstScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {

    private val _userName = MutableLiveData<String>()
    val username: LiveData<String> = _userName

    private val _isPalindrome = MutableLiveData<Boolean>()
    val isPalindrome: LiveData<Boolean> = _isPalindrome

}