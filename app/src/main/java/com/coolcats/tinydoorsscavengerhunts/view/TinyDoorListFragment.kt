package com.coolcats.tinydoorsscavengerhunts.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.coolcats.tinydoorsscavengerhunts.R
import com.coolcats.tinydoorsscavengerhunts.model.TinyDoor
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tiny_door_list_fragment.*

class TinyDoorListFragment : Fragment() {
    private val adapter = TinyDoorRecyclerViewAdapter()
    val tinyDoorLiveData = MutableLiveData<List<TinyDoor>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tiny_door_recyclerview?.adapter = adapter
        tiny_door_recyclerview?.layoutManager = LinearLayoutManager(context)

        adapter.tinyDoorsList

        val dbReference = FirebaseDatabase.getInstance().reference.child("TinyDoors")
        dbReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val tinyDoorList = mutableListOf<TinyDoor>()
                snapshot.children.forEach {
                    it.getValue(TinyDoor::class.java)?.let { item ->
                        tinyDoorList.add(item)
                    }
                }

                tinyDoorLiveData.postValue(tinyDoorList)
            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tiny_door_list_fragment, container, false)
    }

}