package com.smartexpo.android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.smartexpo.android.R
import com.smartexpo.android.activities.presenters.CheckinPresenter
import com.smartexpo.android.activities.presenters.ICheckin
import com.smartexpo.android.adapters.ExpoListAdapter

class CheckinActivity : AppCompatActivity(), ICheckin.View {

    private lateinit var presenter: ICheckin.Presenter
    private lateinit var contentContainer: LinearLayout
    private lateinit var loadingContainer: LinearLayout
    private lateinit var recyclerView: RecyclerView

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkin)

        presenter = CheckinPresenter(this)

        initButton()
        initListView()

    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.cleanUp()
    }

    override fun showLoading() {
        contentContainer = findViewById(R.id.layoutContentContainer)
        loadingContainer = findViewById(R.id.layoutLoadingContainer)
        contentContainer.visibility = View.GONE
        loadingContainer.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        contentContainer.visibility = View.VISIBLE
        loadingContainer.visibility = View.GONE
    }


    private fun initListView() {
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ExpoListAdapter(presenter.loadExpoList())

        recyclerView.apply {
            layoutManager = GridLayoutManager(context,1, GridLayoutManager.VERTICAL,false)
            isNestedScrollingEnabled = false
            onFlingListener = null
        }

    }

    private fun initButton(){
        val btnScan : Button = findViewById(R.id.btn_scan)
        btnScan.setOnClickListener{
            val role = presenter.scanQRCode()
            when(role) {
                'G' -> startActivity(Intent(this,GuestModeActivity::class.java))
            }
        }
    }


}
