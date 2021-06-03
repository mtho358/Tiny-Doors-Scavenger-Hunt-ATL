package com.coolcats.tinydoorsscavengerhunts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coolcats.tinydoorsscavengerhunts.R
import com.coolcats.tinydoorsscavengerhunts.model.TinyDoor
import kotlinx.android.synthetic.main.tiny_door_list_item.view.*

class TinyDoorRecyclerViewAdapter() : RecyclerView.Adapter<TinyDoorRecyclerViewAdapter.TinyDoorViewHolder>() {

    var tinyDoorsList : List<TinyDoor> = mutableListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class TinyDoorViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TinyDoorViewHolder {
        val view = LayoutInflater.from(parent.context).
            inflate(R.layout.tiny_door_list_item, parent, false)
        return TinyDoorViewHolder(view)
    }

    override fun onBindViewHolder(holder: TinyDoorViewHolder, position: Int) {
        val tinyDoor = tinyDoorsList[position]
        holder.itemView.apply {
            tiny_door_name_textview.text = tinyDoor.name.trim()
        }
    }

    override fun getItemCount(): Int = tinyDoorsList.size
}