package com.blas.creditappdemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blas.creditappdemo.ui.list.CustomAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dummydata = arrayOf(
            "Kendaraan 1",
            "Kendaraan 2",
            "Kendaraan 3",
            "Kendaraan 4",
            "Kendaraan 5",
            "Kendaraan 6",
            "Kendaraan 7",
            "Kendaraan 8",
            "Kendaraan 9",
            "Kendaraan 10",
            "Kendaraan 11",
            "Kendaraan 12",
        )

        val adapter = CustomAdapter(dummydata)
        recyclerView.adapter = adapter

        val fabAdd: FloatingActionButton = findViewById(R.id.fabAdd)
        fabAdd.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}