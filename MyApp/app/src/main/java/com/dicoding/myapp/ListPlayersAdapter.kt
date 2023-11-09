package com.dicoding.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListPlayersAdapter(private val listPlayers: ArrayList<Players>) : RecyclerView.Adapter<ListPlayersAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_players, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPlayers.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val players: Players = listPlayers[position]
        holder.imgPhoto.setImageResource(players.photo) // Menggunakan atribut 'photo' dari objek Players
        holder.tvName.text = players.name
        holder.tvDescription.text = players.description
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPlayers[holder.adapterPosition]) }

    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)


    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Players)
    }
}
