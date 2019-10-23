package com.smartexpo.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartexpo.android.Adapter.ExpoListAdapter
import com.smartexpo.android.Model.Expo

class CheckinActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkin)


        /* MOCK UP */
        val expoList = listOf(
            Expo("Motor Show"),
            Expo("Commart"),
            Expo("Mobile Expo"),
            Expo("งานหนังสือ")
        )


        //// Setup RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.apply {
            layoutManager = GridLayoutManager(context,1,GridLayoutManager.VERTICAL,false)
            isNestedScrollingEnabled = false
            adapter = ExpoListAdapter(expoList)
            onFlingListener = null
        }


        //// Setup Button
        val btnScan : Button = findViewById(R.id.btn_scan)
        btnScan.setOnClickListener{
            scanQRCode()
        }

    }

    private fun scanQRCode(){
        val intent = Intent(this,GuestModeActivity::class.java)
        startActivity(intent)
    }
}
