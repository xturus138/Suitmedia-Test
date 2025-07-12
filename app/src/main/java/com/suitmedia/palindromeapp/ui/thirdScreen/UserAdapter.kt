package com.suitmedia.palindromeapp.ui.thirdScreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.suitmedia.palindromeapp.data.model.User
import com.suitmedia.palindromeapp.databinding.ItemUserBinding

class UserAdapter(
    private val users: MutableList<User>,
    private val onClick: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    inner class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.tvName.text = "${user.first_name} ${user.last_name}"
            binding.tvEmail.text = user.email
            Glide.with(binding.imgAvatar.context).load(user.avatar).into(binding.imgAvatar)
            binding.root.setOnClickListener {
                onClick(user)
            }
        }
    }

    fun addUsers(newUsers: List<User>) {
        val startPos = users.size
        users.addAll(newUsers)
        notifyItemRangeInserted(startPos, newUsers.size)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearUsers() {
        users.clear()
        notifyDataSetChanged()
    }
}