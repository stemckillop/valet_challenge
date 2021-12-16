package com.daggy.onevalet.activities.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daggy.onevalet.R
import com.daggy.onevalet.activities.deviceInfo.DeviceActivity
import com.daggy.onevalet.models.Devices

class MainActivity : AppCompatActivity(), MainAdapterDelegate, TextWatcher {

    val viewmodel : MainViewModel by viewModels()

    lateinit var drawer: DrawerLayout
    lateinit var deviceList : RecyclerView
    lateinit var searchView : ConstraintLayout
    lateinit var searchField : EditText
    lateinit var mainAdapter : MainAdapter
    lateinit var mainButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Devices")

        setup()

        deviceList = findViewById(R.id.main_lst_devices)
        searchView = findViewById(R.id.main_view_search)
        searchField = findViewById(R.id.main_edt_search)
        mainButton = findViewById(R.id.main_btn_results)
        searchField.addTextChangedListener(this)

        viewmodel.devices.observe(this) {
            mainAdapter = MainAdapter(it, this@MainActivity)
            deviceList.apply {
                adapter = mainAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
        mainButton.setOnClickListener {
            searchView.visibility = View.GONE
        }
    }

    fun setup() {
        drawer = findViewById<DrawerLayout>(R.id.main_drawer_layout)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var actionDrawable = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(actionDrawable)
        actionDrawable.syncState()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_main_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            if (drawer.isDrawerOpen(Gravity.LEFT)) {
                drawer.closeDrawer(Gravity.LEFT)
            } else {
                drawer.openDrawer(Gravity.LEFT)
            }
        } else if (item.itemId == R.id.nav_main_search) {
            if (searchView.isVisible) {
                searchView.visibility = View.GONE
            } else {
                searchView.visibility = View.VISIBLE
            }
        }

        return false
    }

    override fun onItemClicked(device: Devices) {

        var intent = Intent(this, DeviceActivity::class.java)
        intent.putExtra("device", device)
        startActivity(intent)

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        mainAdapter.getFilteredList(p0.toString())
    }

    override fun afterTextChanged(p0: Editable?) {

    }
}