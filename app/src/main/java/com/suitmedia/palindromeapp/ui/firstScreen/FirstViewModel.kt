package com.suitmedia.palindromeapp.ui.firstScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Locale

class FirstViewModel : ViewModel() {

    private val _userName = MutableLiveData<String>()
    val username: LiveData<String> = _userName

    private val _isPalindrome = MutableLiveData<Boolean>()
    val isPalindrome: LiveData<Boolean> = _isPalindrome

    fun checkPalindrome(input: String): Boolean {
        val clean = input.replace(" ", "").lowercase(Locale.ROOT)
        val reversed = clean.reversed()
        if(reversed.equals(clean)){
            _isPalindrome.value = true
            return true
        }
        _isPalindrome.value = false
        return false
    }

    fun username(name: String){
        _userName.value = name
    }


}