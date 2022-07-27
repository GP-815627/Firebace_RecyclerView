package com.azizbek.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter constructor(
    val contex:Context,
    val arrayList: ArrayList<Model>
): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(contex).inflate(R.layout.recycler_view_layaut,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text=arrayList.get(position).text
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView=itemView.findViewById<TextView>(R.id.textView)
    }
}