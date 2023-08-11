package com.example.bikerentalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.log

class SignUpActivity : AppCompatActivity() {
    private lateinit var btnSignUp: Button
    private lateinit var signName: EditText
    private lateinit var SignPassword: EditText
    private lateinit var SignConfirmPassword: EditText
    private lateinit var singname1: EditText
    private lateinit var login: TextView
    private lateinit var db: DBHelper
    private var emailPattern: String = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        login = findViewById(R.id.Logaccount)
        singname1 = findViewById(R.id.edtName1)
        btnSignUp = findViewById(R.id.btnSignup)
        SignPassword = findViewById(R.id.edtPassword)
        SignConfirmPassword = findViewById(R.id.edtRePassword)
        signName = findViewById(R.id.edtEmail)
        db = DBHelper(this)

        login.setOnClickListener {
            Toast.makeText(this, "Back To Login Activity", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }
        btnSignUp.setOnClickListener {
            val signname2 = singname1.text.toString()
            val signText = signName.text.toString()
            val signPassword = SignPassword.text.toString()
            val signConfirmPassword = SignConfirmPassword.text.toString()
            val saveData = db.insertdata(signname2,signText, signPassword)

            if (signname2.trim().isEmpty()) {
                singname1.error = "Enter Name"
            } else if (signText.trim().isEmpty()) {
                signName.error = "Enter Email Id missing @ - .com"
            } else if (signPassword.trim().isEmpty()) {
                SignPassword.error = "Enter Password"
            } else if (signConfirmPassword.trim().isEmpty()) {
                SignConfirmPassword.error = "Enter Confirm Password"
            } else if (signPassword.trim().length < 6) {
                SignPassword.error = "Enter You 6 no in Password"
            } else if (signConfirmPassword.trim().isEmpty()) {
                SignConfirmPassword.error = "Enter You 6 no in Password"
            }
            /*                if (TextUtils.isEmpty(signText) || TextUtils.isEmpty(signPassword) || TextUtils.isEmpty(
                                    signConfirmPassword
                                )
                            ) {
                                Toast.makeText(this, "Add User Password & ConformPassword", Toast.LENGTH_SHORT)
                                    .show()
                            }*/ else {
                if (signPassword.equals(signConfirmPassword)) {
                    if (saveData == true) {
                        Toast.makeText(this, "SignUp Successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "User Exists", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Password Not Match", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
