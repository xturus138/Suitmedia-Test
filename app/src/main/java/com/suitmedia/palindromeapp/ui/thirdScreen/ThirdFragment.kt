package com.suitmedia.palindromeapp.ui.thirdScreen

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.suitmedia.palindromeapp.R
import com.suitmedia.palindromeapp.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding
    private val viewModel: ThirdViewModel by viewModels()
    private var pageLoaded = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = UserAdapter(mutableListOf()) {user ->
            val fullname = "${user.first_name} ${user.last_name}"
            parentFragmentManager.setFragmentResult("userSelected", Bundle().apply {
                putString("selectedUserName", fullname)
            })
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.rvUser.adapter = adapter

        binding.rvUser.layoutManager = LinearLayoutManager(requireContext())

        binding.pullRefresh.setOnRefreshListener {
            viewModel.loadUsers(refresh = true)
        }

        binding.rvUser.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val lastItem = layoutManager.findLastVisibleItemPosition()
                val totalItem = layoutManager.itemCount

                if (!viewModel.isLoading.value!! && lastItem >= totalItem - 2 && viewModel.morePages()) {
                    viewModel.loadUsers(refresh = false)
                }
            }
        })


        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        viewModel.users.observe(viewLifecycleOwner) { users ->
            if (users.isNotEmpty()) {
                binding.tvEmpty.visibility = View.GONE
                binding.rvUser.visibility = View.VISIBLE
            }

            if(binding.pullRefresh.isRefreshing) {
                adapter.clearUsers()
                adapter.addUsers(users)
                binding.pullRefresh.isRefreshing = false
            } else {
                adapter.addUsers(users.takeLast(users.size - adapter.itemCount))
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { loading ->
            if (loading && adapter.itemCount == 0) {
                binding.pvLoading.visibility = View.VISIBLE
                binding.tvEmpty.visibility = View.GONE
            } else {
                binding.pvLoading.visibility = View.GONE
            }
        }


        viewModel.errorMessage.observe(viewLifecycleOwner) { error ->
            if (error != null) {
                binding.rvUser.visibility = View.GONE
                binding.tvEmpty.visibility = View.VISIBLE
                binding.tvEmpty.text = error

                if (binding.pullRefresh.isRefreshing) {
                    binding.pullRefresh.isRefreshing = false
                }
            }
        }


        viewModel.loadUsers(refresh = true)
    }
}