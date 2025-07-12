package com.suitmedia.palindromeapp.ui.secondScreen

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.suitmedia.palindromeapp.R
import com.suitmedia.palindromeapp.databinding.FragmentSecondBinding
import com.suitmedia.palindromeapp.ui.MainActivity
import com.suitmedia.palindromeapp.ui.firstScreen.FirstFragment
import com.suitmedia.palindromeapp.ui.thirdScreen.ThirdFragment

class SecondFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var mainActivity: MainActivity

    companion object {
        const val KEY_NAME = "key_name"
    }

    private val viewModel: SecondViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = activity as MainActivity
        val username = arguments?.getString(KEY_NAME)
        binding.tvName.text = username
        binding.btnBack.setOnClickListener(this)
        binding.btnChooseUser.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnChooseUser -> {
                val thirdFragment = ThirdFragment()
                mainActivity.replaceFragment(thirdFragment)
            }
            R.id.btnBack -> {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}