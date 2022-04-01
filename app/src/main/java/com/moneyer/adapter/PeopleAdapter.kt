package com.moneyer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moneyer.R
import com.moneyer.responses.StarWarsPeople

class PeopleAdapter :
    RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {
    private var list: MutableList<StarWarsPeople> = mutableListOf()
    fun addData(list: MutableList<StarWarsPeople>) {
        this.list = list
    }

    class PeopleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val peopleName: TextView = view.findViewById(R.id.peopleName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        return PeopleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
        )
    }

    override fun onBindViewHolder(holderPeople: PeopleViewHolder, position: Int) {
        list.getOrNull(position)?.let { people ->
            holderPeople.peopleName.text = people.name
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}