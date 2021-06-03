package com.coolcats.tinydoorsscavengerhunts.model.db

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.coolcats.tinydoorsscavengerhunts.model.TinyDoor
import com.google.firebase.database.*

class FirebaseDB {

    val tinyDoorLiveData = MutableLiveData<List<TinyDoor>>()

    private fun getTinyDoorDatabase(): DatabaseReference = FirebaseDatabase.getInstance().reference.child("TinyDoors")

    fun uploadTinyDoor(tinyDoor: TinyDoor){
        val reference = getTinyDoorDatabase()
        val key = reference.push().key?: ""

        tinyDoor.id = key

        reference.child(key).setValue(tinyDoor)
        Log.d("TAG_M", "${tinyDoor.name} successfully added to database")
    }

    fun insertData(){
    }

    fun readData(): MutableLiveData<List<TinyDoor>>{
        val reference = getTinyDoorDatabase().addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var tinyDoorsList = mutableListOf<TinyDoor>()
                snapshot.children.forEach {
                    it.getValue(TinyDoor::class.java)?.let { item ->
                        tinyDoorsList.add(item)
                    }

                    tinyDoorLiveData.postValue(tinyDoorsList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG_M", "An Error Occured", error.toException())
            }

        })

        return tinyDoorLiveData
    }

}