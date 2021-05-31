package com.coolcats.tinydoorsscavengerhunts.view

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coolcats.tinydoorsscavengerhunts.R
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker1
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker10E
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker10W
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker11
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker12
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker13
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker14
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker15
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker17
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker2
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker21
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker22
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker23
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker25
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker3
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker4
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker8
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.marker9
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.market16
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.market18
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.market20
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.market24
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints.Companion.tinyBusStop

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions

class AtlantaTinyDoorsMapFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        googleMap.addMarker(MarkerOptions().position(marker1).title("Tiny Door #1: Krog Street Tunnel"))
        googleMap.addMarker(MarkerOptions().position(marker2).title("Tiny Door #2: Old Fourth Ward Skatepark on the BeltLine"))
        googleMap.addMarker(MarkerOptions().position(marker3).title("Tiny Door #3: Inman Park Pet Works"))
        googleMap.addMarker(MarkerOptions().position(marker4).title("Tiny Door #4: Little Shop of Stories"))
        googleMap.addMarker(MarkerOptions().position(marker8).title("Tiny Door #8: Milltown Arms Tavern"))
        googleMap.addMarker(MarkerOptions().position(marker9).title("Tiny Door #9: King of Pops"))
        googleMap.addMarker(MarkerOptions().position(marker10E).title("Tiny Door #10E: Grant Park East"))
        googleMap.addMarker(MarkerOptions().position(marker10W).title("Tiny Door #10W: Grant Park West"))
        googleMap.addMarker(MarkerOptions().position(marker11).title("Tiny Door #11: Center for Puppetry Arts"))
        googleMap.addMarker(MarkerOptions().position(marker12).title("Tiny Door #12: Westside BeltLine Trail"))
        googleMap.addMarker(MarkerOptions().position(marker13).title("Tiny Door #13: BeltLine Eastside Trail"))
        googleMap.addMarker(MarkerOptions().position(marker14).title("Tiny Door #14: EAV Farmers Market"))
        googleMap.addMarker(MarkerOptions().position(marker15).title("Tiny Door #15: Fox Theatre"))
        googleMap.addMarker(MarkerOptions().position(market16).title("Tiny Door #16: State Farm Arena"))
        googleMap.addMarker(MarkerOptions().position(marker17).title("Tiny Door #17: Woodruff Park"))
        googleMap.addMarker(MarkerOptions().position(market18).title("Tiny Door #18: ASO at Woodruff Arts Center"))
        googleMap.addMarker(MarkerOptions().position(market20).title("Tiny Door #19: Giant Door"))
        googleMap.addMarker(MarkerOptions().position(marker21).title("Tiny Door #20: Coan Park"))
        googleMap.addMarker(MarkerOptions().position(marker22).title("Tiny Door #19: Giant Door"))
        googleMap.addMarker(MarkerOptions().position(marker23).title("Tiny Door #6: Swan House Door"))
        googleMap.addMarker(MarkerOptions().position(market24).title("Tiny Door #5: Aquarium Door"))
        googleMap.addMarker(MarkerOptions().position(marker25).title("Tiny Door #10: Tiny Door at Centennial Olympic Park"))
        googleMap.addMarker(MarkerOptions().position(tinyBusStop).title("Tiny Street! "))

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tinyBusStop, 15f))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.atlanta_tiny_doors_map_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}