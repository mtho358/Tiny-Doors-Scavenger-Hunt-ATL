package com.coolcats.tinydoorsscavengerhunts.view

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coolcats.tinydoorsscavengerhunts.R
import com.coolcats.tinydoorsscavengerhunts.model.TinyDoor
import com.coolcats.tinydoorsscavengerhunts.viewmodel.TinyDoorViewModel

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class AtlantaTinyDoorsMapFragment : Fragment() {



    private val callback = OnMapReadyCallback { googleMap ->
        val dbReference = FirebaseDatabase.getInstance().reference.child("TinyDoors")
        dbReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach {
                    it.getValue(TinyDoor::class.java)?.let { item ->
                        googleMap.addMarker(MarkerOptions().title(item.name.trim()).position(LatLng(item.lat, item.lon)))
                    }
                }
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tinyStreet, 10f))
            }

            val tinyStreet = LatLng(33.7490684,-84.3589557)

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
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
        val mapFragment = childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}