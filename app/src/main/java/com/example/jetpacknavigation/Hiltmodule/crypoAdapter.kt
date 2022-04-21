package com.example.jetpacknavigation.Hiltmodule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpacknavigation.R

class crypoAdapter (val cryptocurency: List<Cryptocurency>): RecyclerView.Adapter<crypoAdapter.Viewholder>() {

    open class Viewholder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
         fun bind(pos:Cryptocurency)
         {
             Glide.with(itemView.context)
                 .load(pos.image).dontAnimate()
                 .into(itemView.findViewById(R.id.imageView))
             // Setting name of cryptocurrency to TextView
             itemView.findViewById<TextView>(R.id.textView).text = pos.name
         }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bind(cryptocurency[position])

    }

    override fun getItemCount(): Int {
     return   cryptocurency.size
    }
}