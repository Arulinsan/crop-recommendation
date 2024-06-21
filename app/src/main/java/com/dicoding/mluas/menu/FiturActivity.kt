package com.dicoding.mluas.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mluas.R
import com.dicoding.mluas.recycler.DataFitur
import com.dicoding.mluas.recycler.FiturAdapter

class FiturActivity : AppCompatActivity() {

    private lateinit var rvFitur: RecyclerView
    private val list = ArrayList<DataFitur>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitur)
        rvFitur = findViewById(R.id.rv_fitur)
        rvFitur.setHasFixedSize(true)
        list.addAll(getListFitur())
        showRecyclerlist()
    }

    private fun getListFitur(): ArrayList<DataFitur> {
        val dataName = resources.getStringArray(R.array.fitur_name)
        val dataDescription = resources.getStringArray(R.array.fitur_desc)
        val listfitur = ArrayList<DataFitur>()
        for (i in dataName.indices) {
            val fitur = DataFitur(dataName[i], dataDescription[i])
            listfitur.add(fitur)
        }
        return listfitur
    }

    private fun showRecyclerlist() {
        rvFitur.layoutManager = LinearLayoutManager(this)
        val listCitiesAdapter = FiturAdapter(list)
        rvFitur.adapter = listCitiesAdapter
    }
}