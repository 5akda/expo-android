package com.smartexpo.android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartexpo.android.R
import com.smartexpo.android.activities.presenters.CheckinPresenter
import com.smartexpo.android.activities.presenters.ICheckin
import com.smartexpo.android.adapters.ExpoListAdapter

class CheckinActivity : AppCompatActivity(), ICheckin.View {

    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: CheckinPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkin)

        presenter = CheckinPresenter(view = this)
        renderExpoList()

        //// Setup Button
        val btnScan : Button = findViewById(R.id.btn_scan)
        btnScan.setOnClickListener{
            val role = presenter.scanQRCode()
            when(role) {
                'G' -> startActivity(Intent(this,GuestModeActivity::class.java))
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.cleanUp()
    }

    override fun renderExpoList() {

        val expoList = presenter.loadExpoList()

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.apply {
            layoutManager = GridLayoutManager(context,1,GridLayoutManager.VERTICAL,false)
            isNestedScrollingEnabled = false
            adapter = ExpoListAdapter(expoList)
            onFlingListener = null
        }
    }

}
