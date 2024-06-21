package com.dicoding.mluas.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mluas.R

class DatasetAdapter(private val listDataset: ArrayList<Dataset>) : RecyclerView.Adapter<DatasetAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.dataset_row, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listDataset.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description) = listDataset[position]
        holder.nama.text = name
        holder.data.text = description
    }

    class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val nama : TextView = itemView.findViewById(R.id.id_kolom_dataset)
        val data : TextView = itemView.findViewById(R.id.id_baris_dataset)
    }
}