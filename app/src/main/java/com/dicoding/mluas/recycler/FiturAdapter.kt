package com.dicoding.mluas.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mluas.R

class FiturAdapter(private val listFitur: ArrayList<DataFitur>) : RecyclerView.Adapter<FiturAdapter.ListViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.fitur_row, parent, false)
        return  ListViewHolder(view)
    }

    override fun getItemCount(): Int = listFitur.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description) = listFitur[position]
        holder.nama.text = name
        holder.desk.text = description
    }
    class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val nama : TextView = itemView.findViewById(R.id.id_nama_fitur)
        val desk : TextView = itemView.findViewById(R.id.fitur_desc)
    }
}