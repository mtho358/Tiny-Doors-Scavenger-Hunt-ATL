package com.coolcats.tinydoorsscavengerhunts.util

import com.coolcats.tinydoorsscavengerhunts.R
import com.google.android.gms.maps.model.LatLng
import java.util.concurrent.TimeUnit


class GeofencingConstants {

    data class LandmarkDataObject(val id: String, val name: Int, val markerPoint: LatLng)

    internal object GeofencingConstants{
        val GEOFENCE_EXPERACTION_IN_MILLISECONDS: Long = TimeUnit.HOURS.toMillis(1)

        val LANDMARK_DATA = arrayOf(
            LandmarkDataObject(
                "Door #1",
                R.string.door_1,
                MarkerPoints.marker1
            )
        )

        val NUM_LANDMARKS = LANDMARK_DATA.size
        const val GEOFENCE_RADIUS_IN_METERS = 100f
        const val EXTRA_GEOFENCE_INDEX = "GEOFENCE_INDEX"
    }

}