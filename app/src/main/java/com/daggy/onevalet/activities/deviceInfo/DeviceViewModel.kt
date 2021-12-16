package com.daggy.onevalet.activities.deviceInfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daggy.onevalet.models.Devices

class DeviceViewModel : ViewModel() {

    var device: MutableLiveData<Devices> = MutableLiveData()

    fun initFromIntent(device: Devices) {
        this.device.value = device
    }

}