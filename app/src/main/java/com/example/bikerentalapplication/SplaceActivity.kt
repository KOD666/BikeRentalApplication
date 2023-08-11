package com.example.bikerentalapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AlphaAnimation
import android.widget.ImageView

class SplaceActivity : AppCompatActivity() {

    private lateinit var splace: ImageView
    lateinit var sp: SharedPreferences;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace)
        sp = getSharedPreferences(ConstantData.PREF, MODE_PRIVATE)
        supportActionBar?.hide()
        splace = findViewById(R.id.img_splace)
        var animation: AlphaAnimation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 5000
        animation.repeatCount = 3
        splace.startAnimation(animation)
        Handler().postDelayed({
            if (sp.getString(ConstantData.EMAIL, "").equals("")) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, DrawerActivity::class.java)
                startActivity(intent)
                finish()
            }
            //   Toast.makeText(this@SplaceActivity, "Splace Succesfully", Toast.LENGTH_SHORT).show()
        }, 3000)
    }
}