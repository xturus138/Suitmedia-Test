package com.suitmedia.palindromeapp.ui.thirdScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suitmedia.palindromeapp.data.model.User
import com.suitmedia.palindromeapp.data.repository.RetrofitClient
import kotlinx.coroutines.launch

class ThirdViewModel : ViewModel() {

    private val _users = MutableLiveData<List<User>>(emptyList())
    val users: LiveData<List<User>> = _users

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private var currentPage = 1
    private var totalPages = 1
    private val perPage = 6

    fun loadUsers(refresh: Boolean = false) {
        if (_isLoading.value == true) return

        if (refresh) {
            currentPage = 1
            totalPages = 1
            _users.value = emptyList()
        } else {
            if (currentPage > totalPages) return
        }

        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = RetrofitClient.userService.getUsers(page = currentPage, perPage = perPage)
                totalPages = response.total_pages
                val currentList = if (refresh) emptyList() else _users.value ?: emptyList()
                val newList = currentList + response.data

                _users.value = newList
                currentPage++
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load data: ${e.message}"
                e.printStackTrace() //janlup nanti dihapus
            }
            _isLoading.value = false
        }
    }

    fun morePages(): Boolean {
        return currentPage <= totalPages
    }

}