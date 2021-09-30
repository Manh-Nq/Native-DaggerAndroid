package com.example.dependencynow.screens.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencynow.database.model.Person
import com.example.dependencynow.screens.main.holder.MainPersonViewHolder

class MainPersonAdapter(val listener: PersonListener) :
    ListAdapter<Person, RecyclerView.ViewHolder>(PersonDiff()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainPersonViewHolder.create(parent, listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainPersonViewHolder).build(getItem(position))
    }

}

class PersonDiff : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return true
    }
}

data class PersonListener(val deleteClicked: (Person) -> Unit, val itemClicked: (Person) -> Unit)