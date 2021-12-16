package com.daggy.onevalet.activities.main

import com.daggy.onevalet.models.Devices

interface MainAdapterDelegate {
    fun onItemClicked(device: Devices)
}