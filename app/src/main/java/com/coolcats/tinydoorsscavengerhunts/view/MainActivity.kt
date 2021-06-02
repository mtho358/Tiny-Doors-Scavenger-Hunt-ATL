package com.coolcats.tinydoorsscavengerhunts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coolcats.tinydoorsscavengerhunts.R
import com.coolcats.tinydoorsscavengerhunts.model.db.FirebaseDB
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        list_button.setOnClickListener {
            val fragment = TinyDoorListFragment()

            supportFragmentManager.beginTransaction()
                .addToBackStack(fragment.tag)
                .replace(R.id.map_fragment, fragment)
                .commit()
        }

    }

}