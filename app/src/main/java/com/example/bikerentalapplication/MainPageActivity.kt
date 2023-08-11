package com.example.bikerentalapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainPageActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    val cityName =
        arrayOf("Ahmedabad ", "Ahmedabad ", "Ahmedabad ", "Ahmedabad ", "Ahmedabad ", "Ahmedabad ")
    val cityImage = arrayOf(
        R.drawable.ic_launcher_ahemdabad_background,
        R.drawable.ic_launcher_ahemdabad_background,
        R.drawable.ic_launcher_ahemdabad_background,
        R.drawable.ic_launcher_ahemdabad_background,
        R.drawable.ic_launcher_ahemdabad_background,
        R.drawable.ic_launcher_ahemdabad_background,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
    }
}