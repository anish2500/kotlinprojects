package com.example.assignment.adapter

import android.content.ClipDescription
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R

class recylerAdapter (
    val context: Context,
    val cityInfos : Array<Int>,
    val cityTitle : Array<String>,
    val cityDesc : Array<String>


    ): RecyclerView.Adapter<recylerAdapter.recyclerAdapterViewHolder>(){
        class recyclerAdapterViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            var image : ImageView = itemView.findViewById(R.id.baudhaimage)
            var title : TextView = itemView.findViewById(R.id.ktmText)
            var desc : TextView = itemView.findViewById(R.id.badhaDescp)
        }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): recylerAdapter.recyclerAdapterViewHolder {
        val itemView : View = LayoutInflater.from(context).inflate(R.layout.recycler_images,parent, false)
        return recyclerAdapterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: recylerAdapter.recyclerAdapterViewHolder, position: Int) {
        holder.image.setImageResource(cityInfos[position])
        holder.title.text = cityTitle[position]
        holder.desc.text = cityDesc[position]
    }

    override fun getItemCount(): Int {
        return cityInfos.size
    }


}