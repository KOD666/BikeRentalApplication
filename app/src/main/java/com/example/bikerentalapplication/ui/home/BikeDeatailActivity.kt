package com.example.bikerentalapplication.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.bikerentalapplication.R

class BikeDeatailActivity : AppCompatActivity() {
    private lateinit var category_detail_Image : ImageView
    private lateinit var category_detail_Name : TextView
    private lateinit var confirm : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bike_deatail)
        category_detail_Image = findViewById(R.id.category_detail_image1)
        category_detail_Name = findViewById(R.id.category_detail_name1)
        var bundle:Bundle= intent.extras!!
        supportActionBar?.title= bundle.getString("CAT_NAME")
        category_detail_Name.text = bundle.getString("CAT_NAME")
        category_detail_Image.setImageResource(bundle.getInt("CAT_IMAGE"))
        confirm = findViewById(R.id.confirm_button)
        confirm.setOnClickListener {
            val intent = Intent(this@BikeDeatailActivity,ConfirmActivity::class.java)
            Toast.makeText(this, "Confirm", Toast.LENGTH_SHORT).show()
            startActivity(intent)

        }

    }
}