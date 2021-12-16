package com.daggy.onevalet.repo

import com.daggy.onevalet.models.DeviceStatus
import com.daggy.onevalet.models.Devices

object TestSource {
    fun get_deviceList() : List<Devices> {
        var arr = arrayListOf<Devices>()

        arr.add(Devices(1, "Samsung S20", DeviceStatus.UNAVAILABLE))
        arr.add(Devices(2, "Google Pixel 3", DeviceStatus.AVAILABLE))
        arr.add(Devices(3, "Apple iPhone 9", DeviceStatus.AVAILABLE))
        arr.add(Devices(4, "OneNote Plus 3", DeviceStatus.UNAVAILABLE))
        arr.add(Devices(5, "Samsung s4", DeviceStatus.UNAVAILABLE))

        return arr.toList()
    }
}