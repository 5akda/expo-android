package com.smartexpo.android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.smartexpo.android.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup Button //
        val btnCreate : Button = findViewById(R.id.btn_create)
        btnCreate.setOnClickListener{
            Toast.makeText(this,"Created",Toast.LENGTH_SHORT).show()
        }
        val btnSignIn : TextView = findViewById(R.id.btn_signin)
        btnSignIn.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
