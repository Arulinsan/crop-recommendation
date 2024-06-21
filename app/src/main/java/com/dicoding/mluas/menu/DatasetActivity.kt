package com.dicoding.mluas.menu


import android.graphics.Color
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mluas.R
import com.dicoding.mluas.recycler.Dataset
import com.dicoding.mluas.recycler.DatasetAdapter


class DatasetActivity : AppCompatActivity() {
    private lateinit var rvDataset: RecyclerView
    private val list = ArrayList<Dataset>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dataset)
        rvDataset = findViewById(R.id.rv_dataset)
        rvDataset.setHasFixedSize(true)
        list.addAll(getListDataset())
        showRecyclerlist()
//

    }

    private fun getListDataset(): ArrayList<Dataset> {
        val dataName = resources.getStringArray(R.array.dataset_name)
        val dataDescription = resources.getStringArray(R.array.dataset)
        val listfitur = ArrayList<Dataset>()
        for (i in dataName.indices) {
            val fitur = Dataset(dataName[i], dataDescription[i])
            listfitur.add(fitur)
        }
        return listfitur
    }

    private fun showRecyclerlist() {
        rvDataset.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        val listCitiesAdapter = DatasetAdapter(list)
        rvDataset.adapter = listCitiesAdapter
    }
}