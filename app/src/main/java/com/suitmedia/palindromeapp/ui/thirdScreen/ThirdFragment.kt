package com.suitmedia.palindromeapp.ui.thirdScreen

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.suitmedia.palindromeapp.R

class ThirdFragment : Fragment() {

    companion object {
        fun newInstance() = ThirdFragment()
    }

    private val viewModel: ThirdViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }
}