package com.suitmedia.palindromeapp.ui.firstScreen

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.suitmedia.palindromeapp.R
import com.suitmedia.palindromeapp.databinding.FragmentFirstBinding
import com.suitmedia.palindromeapp.ui.MainActivity
import com.suitmedia.palindromeapp.ui.secondScreen.SecondFragment

class FirstFragment : Fragment(), View.OnClickListener {

    companion object {
        const val TAG = "FirstFragment"
    }

    private lateinit var binding: FragmentFirstBinding
    private lateinit var mainActivity: MainActivity


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
        mainActivity = activity as MainActivity
        binding.btnCheck.setOnClickListener(this)
        binding.btnNext.setOnClickListener(this)

        viewModel.username.observe(viewLifecycleOwner) {data ->
            //kela euy kudu datastore hela
        }

        viewModel.isPalindrome.observe(viewLifecycleOwner) {palindrome ->
            if(palindrome){
                Toast.makeText(requireContext(), "isPalindrome", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "not palindrome", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCheck -> {
                val input = binding.txtInputPalindrome.text.toString().ifEmpty { "Wrong" }
                val name = binding.txtInputName.text.toString().ifEmpty { "John Doe" }
                viewModel.checkPalindrome(input)
            }

            R.id.btnNext -> {
                mainActivity.replaceFragment(SecondFragment())
            }
        }
    }
}