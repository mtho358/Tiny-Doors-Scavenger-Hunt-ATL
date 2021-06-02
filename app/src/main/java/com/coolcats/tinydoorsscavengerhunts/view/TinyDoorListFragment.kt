package com.coolcats.tinydoorsscavengerhunts.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.coolcats.tinydoorsscavengerhunts.R
import com.coolcats.tinydoorsscavengerhunts.model.TinyDoor
import com.google.android.gms.maps.MapFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tiny_door_list_fragment.*

class TinyDoorListFragment : Fragment() {
    private val adapter = TinyDoorRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tiny_door_recyclerview?.adapter = adapter
        tiny_door_recyclerview?.layoutManager = LinearLayoutManager(context)

        FirebaseDatabase.getInstance().reference.child("TinyDoors")
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var tinyDoorsList = mutableListOf<TinyDoor>()
                    snapshot.children.forEach {
                        it.getValue(TinyDoor::class.java)?.let { item ->
                            tinyDoorsList.add(item)
                        }
                    }

                    adapter.tinyDoorsList = tinyDoorsList
                    Log.d("TAG_M", "${tinyDoorsList.size}")
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("TAG_M", "An Error Occured", error.toException())
                }
            })

//        back_floatingActionButton.setOnClickListener {
//            var fragment = TinyDoorListFragment()
//            supportFragmentManager.beginTransaction()
//                .addToBackStack(fragment.tag)
//                .replace(R.id.tiny_door_list_fragement, map_fragment)
//                .commit()
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tiny_door_list_fragment, container, false)
    }

}