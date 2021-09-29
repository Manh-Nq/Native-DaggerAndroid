package com.example.dependencynow.screens.main.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencynow.database.model.Person
import com.example.dependencynow.databinding.PersonItemBinding

class MainPersonViewHolder(val binding: PersonItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun build(item: Person) = with(binding) {
        name.text = item.name
        age.text = item.age.toString()
    }

    companion object {
        fun create(parent: ViewGroup): MainPersonViewHolder {
            return MainPersonViewHolder(
                PersonItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}