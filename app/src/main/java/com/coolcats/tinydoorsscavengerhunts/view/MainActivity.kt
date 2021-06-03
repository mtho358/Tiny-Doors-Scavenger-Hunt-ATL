package com.coolcats.tinydoorsscavengerhunts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.coolcats.tinydoorsscavengerhunts.R
import com.coolcats.tinydoorsscavengerhunts.model.TinyDoor
import com.coolcats.tinydoorsscavengerhunts.model.db.FirebaseDB
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val tinyDoorLiveData = MutableLiveData<List<TinyDoor>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu_button.setOnClickListener {
            val fragment = TinyDoorListFragment()

            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    android.R.anim.fade_in,
                    android.R.anim.fade_out,
                    android.R.anim.fade_in,
                    android.R.anim.fade_out
                ).replace(R.id.map_fragment, fragment)
                .addToBackStack(fragment.tag)
                .commit()
        }
    }
}