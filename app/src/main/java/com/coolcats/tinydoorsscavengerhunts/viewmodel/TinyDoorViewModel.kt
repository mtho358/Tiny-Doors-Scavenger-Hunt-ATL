package com.coolcats.tinydoorsscavengerhunts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.coolcats.tinydoorsscavengerhunts.model.TinyDoor
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class TinyDoorViewModel(stateHandle: SavedStateHandle) : ViewModel() {

    var tinyDoorLiveData = MutableLiveData<List<TinyDoor>>()

}