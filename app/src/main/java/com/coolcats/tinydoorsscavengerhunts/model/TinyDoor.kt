package com.coolcats.tinydoorsscavengerhunts.model

import com.google.android.gms.maps.model.LatLng

data class TinyDoor(var id: String, var name: String, var lat: Double, var lon: Double){
    constructor():this("", "", 0.0, 0.0)
}