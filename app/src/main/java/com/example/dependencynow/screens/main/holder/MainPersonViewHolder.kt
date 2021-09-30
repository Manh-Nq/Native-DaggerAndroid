package com.example.dependencynow.screens.main.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencynow.database.model.Person
import com.example.dependencynow.databinding.PersonItemBinding
import com.example.dependencynow.screens.main.adapter.PersonListener

class MainPersonViewHolder(val binding: PersonItemBinding, val listener: PersonListener) :
    RecyclerView.ViewHolder(binding.root) {

    fun build(item: Person) = with(binding) {
        name.text = item.name
        age.text = item.age.toString()
        trash.setOnClickListener {
            listener.deleteClicked(item)
        }
        root.setOnClickListener {
            listener.itemClicked(item)
        }
    }

    companion object {
        fun create(parent: ViewGroup, listener: PersonListener): MainPersonViewHolder {
            return MainPersonViewHolder(
                PersonItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), listener
            )
        }
    }
}