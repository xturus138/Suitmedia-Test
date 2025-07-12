package com.suitmedia.palindromeapp.ui.firstScreen

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.suitmedia.palindromeapp.R
import com.suitmedia.palindromeapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentFirstBinding


    private val viewModel: FirstViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCheck.setOnClickListener(this)
        binding.btnNext.setOnClickListener(this)

        viewModel.username.observe(viewLifecycleOwner) {data ->

        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCheck -> {

            }

            R.id.btnNext -> {

            }
        }
    }
}