package com.smartexpo.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        // Setup EditText //
        val txtUsername : EditText = findViewById(R.id.txt_username)
        val txtPassword : EditText = findViewById(R.id.txt_password)

        // Setup Button //
        val btnLogin : Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener{
            login(txtUsername.text.toString(), txtPassword.text.toString())
        }
        val btnSignUp : TextView = findViewById(R.id.btn_signup)
        btnSignUp.setOnClickListener{

        }
    }

    private fun login(username:String, password:String){
        val intent = Intent(this, CheckinActivity::class.java)
        startActivity(intent)
    }
}
