package com.daggy.onevalet.activities.deviceInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.daggy.onevalet.R
import com.daggy.onevalet.databinding.ActivityDeviceBinding
import com.daggy.onevalet.models.Devices

class DeviceActivity : AppCompatActivity() {

    val viewmodel : DeviceViewModel by viewModels()
    lateinit var binding : ActivityDeviceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_device)
        binding.viewmodel = viewmodel

        var device = intent.extras?.getSerializable("device") as Devices
        viewmodel.initFromIntent(device)
        viewmodel.device.observe(this) {
            setTitle("Device: ${it.name}")
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return true
    }
}