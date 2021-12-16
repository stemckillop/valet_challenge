package com.daggy.onevalet.activities.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daggy.onevalet.models.Devices
import com.daggy.onevalet.repo.TestSource

class MainViewModel : ViewModel() {

    var devices : MutableLiveData<List<Devices>> = MutableLiveData(TestSource.get_deviceList())

}