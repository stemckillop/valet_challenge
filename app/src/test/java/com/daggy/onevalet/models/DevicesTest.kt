package com.daggy.onevalet.models

import org.junit.Assert.*

import org.junit.Test

class DevicesTest {

    @Test
    fun getUnavailableFriendlyStatus() {
        val device = Devices(1, "Test", DeviceStatus.UNAVAILABLE)
        assertEquals("Unavailable", device.getFriendlyStatus())
    }

    @Test
    fun getAvailableFriendlyStatus() {
        val device = Devices(1, "Test", DeviceStatus.AVAILABLE)
        assertEquals("Available", device.getFriendlyStatus())
    }

    @Test
    fun getScreenSizeFriendly() {
        val device = Devices(1, "Test", DeviceStatus.AVAILABLE, "Android 10", 1080, 1920, 2.5f)
        assertEquals("1080 x 1920", device.getFriendlySize())
    }
}