package com.example.retoroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retoroom.database.User
import org.json.JSONArray
import org.json.JSONObject
import com.example.retoroom.databinding.ItemDataBinding

class MainAdapter(private val users : List<User>): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.render(users[position])
    }

    override fun getItemCount(): Int = users.size


    class MainHolder(val binding: ItemDataBinding):RecyclerView.ViewHolder(binding.root){
        fun render(user : User){
            binding.textView.setText(user.user_name)
        }
    }
}
