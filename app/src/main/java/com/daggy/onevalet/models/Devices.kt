package com.daggy.onevalet.models

import java.io.Serializable

data class Devices(var id: Int, var name: String, var status: DeviceStatus = DeviceStatus.UNAVAILABLE, var OS: String = "None", var screen_width: Int = 0, var screen_height: Int = 0, var rating: Float = 0f) : Serializable {
    fun getFriendlyStatus() : String {
        when (status) {
            DeviceStatus.UNAVAILABLE -> return "Unavailable"
            DeviceStatus.AVAILABLE -> return "Available"
            else -> {
                return "Ooops..."
            }
        }

        return "Wow...Big error..."
    }

    fun getFriendlySize() : String {
        return "${screen_width} x ${screen_height}"
    }
}
