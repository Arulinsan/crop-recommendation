package com.dicoding.mluas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import com.dicoding.mluas.menu.AboutActivity
import com.dicoding.mluas.menu.DatasetActivity
import com.dicoding.mluas.menu.FiturActivity
import com.dicoding.mluas.menu.ModelActivity
import com.dicoding.mluas.menu.SimulasiActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val MenuAbout : ConstraintLayout = findViewById(R.id.menu_about)
        MenuAbout.setOnClickListener(this)

        val MenuSimulasi: ConstraintLayout = findViewById(R.id.id_simulasi)
        MenuSimulasi.setOnClickListener(this)

        val MenuDataset: ConstraintLayout = findViewById(R.id.id_dataset)
        MenuDataset.setOnClickListener(this)

        val MenuFitur: ConstraintLayout = findViewById(R.id.id_fitur)
        MenuFitur.setOnClickListener(this)

        val MenuModel: ConstraintLayout = findViewById(R.id.id_model)
        MenuModel.setOnClickListener(this)

        val back : ImageView = findViewById(R.id.arrow)
        back.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.menu_about ->{
                val moveIntent = Intent(this@HomeActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.id_simulasi ->{
                val moveIntent = Intent(this@HomeActivity, SimulasiActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.id_dataset ->{
                val moveIntent = Intent(this@HomeActivity, DatasetActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.id_fitur->{
                val moveIntent = Intent(this@HomeActivity, FiturActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.id_model ->{
                val moveIntent = Intent(this@HomeActivity, ModelActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.arrow ->{
                finish()
            }
        }
    }
}