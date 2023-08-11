package com.example.bikerentalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var btnLogin : Button
    private lateinit var loginName : EditText
    private lateinit var loginPassword : EditText
    private lateinit var dbh:DBHelper
    private lateinit var signup : TextView

    private var emailPattern: String = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin = findViewById(R.id.btnLogin)
        loginName = findViewById(R.id.edtLName)
        loginPassword = findViewById(R.id.edtLPassword)
        dbh = DBHelper(this)
        signup = findViewById(R.id.account)
        signup.setOnClickListener {
            Toast.makeText(this, "Back To SignUP Activity", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext,SignUpActivity::class.java)
            startActivity(intent)
        }
        //   backLogin = findViewById(R.id.)
        /*
                backLogin.setOnClickListener {
                    Toast.makeText(this, "Back To SignUP Activity", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext,SignActivity::class.java)
                    startActivity(intent)
                }
        */
        btnLogin.setOnClickListener {
            val userName = loginName.text.toString()
            val userPassword = loginPassword.text.toString()

            if (loginName.text.trim().isEmpty()) {
                loginName.error = "Enter Email"
            } else if (!loginName.text.toString().matches(Regex(emailPattern))) {
                loginName.error = "Plz Email in Proper Syntax"
            } else if (loginPassword.text.trim().isEmpty()) {
                loginPassword.error = "Enter Password"
            } else if (loginPassword.text.trim().length < 6) {
                loginPassword.error = "Enter You 6 no in Password"
            }
            /*            if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(userPassword)){
                            Toast.makeText(this, "Add username & password", Toast.LENGTH_SHORT).show()
                        }*/else{
                val checkuser = dbh.checkuserpass(userName,userPassword)
                if (checkuser==true){
                    val intent = Intent(applicationContext,DrawerActivity::class.java)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                }else{


                    Toast.makeText(this, "WRONG PASSWORD AND NAME", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}