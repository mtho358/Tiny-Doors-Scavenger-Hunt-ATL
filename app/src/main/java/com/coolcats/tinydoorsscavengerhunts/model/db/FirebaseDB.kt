package com.coolcats.tinydoorsscavengerhunts.model.db

import android.util.Log
import com.coolcats.tinydoorsscavengerhunts.model.TinyDoor
import com.coolcats.tinydoorsscavengerhunts.util.MarkerPoints
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FirebaseDB {

    private fun getTinyDoorDatabase(): DatabaseReference = FirebaseDatabase.getInstance().reference.child("TinyDoors")

    fun uploadTinyDoor(tinyDoor: TinyDoor){
        val reference = getTinyDoorDatabase()
        val key = reference.push().key?: ""

        tinyDoor.id = key

        reference.child(key).setValue(tinyDoor)
        Log.d("TAG_M", "${tinyDoor.name} successfully added to database")
    }

    fun insertData(){
        var tinyDoor1 = uploadTinyDoor( TinyDoor(
            "1",
            "Tiny Door #1: Krog Street Tunnel",
            MarkerPoints.marker1.latitude,
            MarkerPoints.marker1.longitude
        ))

        var tinyDoor2 = uploadTinyDoor( TinyDoor(
            "2",
            "Tiny Door #2: Old Fourth Ward Skatepark on the BeltLine",
            MarkerPoints.marker2.latitude,
            MarkerPoints.marker2.longitude
        ))

        var tinyDoor3 = uploadTinyDoor( TinyDoor(
            "3",
            "Tiny Door #3: Inman Park Pet Works",
            MarkerPoints.marker3.latitude,
            MarkerPoints.marker3.longitude
        ))

        var tinyDoor4 = uploadTinyDoor( TinyDoor(
            "4",
            "Tiny Door #4: Little Shop of Stories",
            MarkerPoints.marker4.latitude,
            MarkerPoints.marker4.longitude
        ))

        var tinyDoor5 = uploadTinyDoor( TinyDoor(
            "8",
            "Tiny Door #8: Milltown Arms Tavern",
            MarkerPoints.marker8.latitude,
            MarkerPoints.marker8.longitude
        ))

        var tinyDoor6 = uploadTinyDoor( TinyDoor(
            "9",
            "Tiny Door #9: King of Pops",
            MarkerPoints.marker8.latitude,
            MarkerPoints.marker8.longitude
        ))

        var tinyDoor7 = uploadTinyDoor( TinyDoor(
            "10E",
            "Tiny Door #10E: Grant Park East",
            MarkerPoints.marker10E.latitude,
            MarkerPoints.marker10E.longitude
        ))

        var tinyDoor8 = uploadTinyDoor( TinyDoor(
            "10W",
            "Tiny Door #10W: Grant Park West",
            MarkerPoints.marker10W.latitude,
            MarkerPoints.marker10W.longitude
        ))

        var tinyDoor9 = uploadTinyDoor( TinyDoor(
            "11",
            "Tiny Door #11: Center for Puppetry Arts",
            MarkerPoints.marker11.latitude,
            MarkerPoints.marker11.longitude
        ))

        var tinyDoor10 = uploadTinyDoor( TinyDoor(
            "12",
            "Tiny Door #12: Westside BeltLine Trail",
            MarkerPoints.marker12.latitude,
            MarkerPoints.marker12.longitude
        ))

        var tinyDoor11 = uploadTinyDoor( TinyDoor(
            "13",
            "Tiny Door #13: BeltLine Eastside Trail",
            MarkerPoints.marker13.latitude,
            MarkerPoints.marker13.longitude
        ))

        var tinyDoor12 = uploadTinyDoor( TinyDoor(
            "14",
            "Tiny Door #14: EAV Farmers Market",
            MarkerPoints.marker14.latitude,
            MarkerPoints.marker14.longitude
        ))

        var tinyDoor13 = uploadTinyDoor( TinyDoor(
            "15",
            "Tiny Door #15: Fox Theatre",
            MarkerPoints.marker15.latitude,
            MarkerPoints.marker15.longitude
        ))

        var tinyDoor14 = uploadTinyDoor( TinyDoor(
            "16",
            "Tiny Door #16: State Farm Arena",
            MarkerPoints.marker16.latitude,
            MarkerPoints.marker16.longitude
        ))

        var tinyDoor15 = uploadTinyDoor( TinyDoor(
            "17",
            "Tiny Door #17: Woodruff Park",
            MarkerPoints.marker17.latitude,
            MarkerPoints.marker17.longitude
        ))

        var tinyDoor18 = uploadTinyDoor( TinyDoor(
            "18",
            "Tiny Door #18: ASO at Woodruff Arts Center",
            MarkerPoints.marker18.latitude,
            MarkerPoints.marker18.longitude
        ))

        var tinyDoor19 = uploadTinyDoor( TinyDoor(
            "20",
            "Tiny Door #19: Giant Door",
            MarkerPoints.marker20.latitude,
            MarkerPoints.marker20.longitude
        ))

        var tinyDoor20 = uploadTinyDoor( TinyDoor(
            "21",
            "Tiny Door #20: Coan Park",
            MarkerPoints.marker21.latitude,
            MarkerPoints.marker21.longitude
        ))

        var tinyDoor21 = uploadTinyDoor( TinyDoor(
            "22",
            "Tiny Door 658",
            MarkerPoints.marker22.latitude,
            MarkerPoints.marker22.longitude
        ))

        var tinyDoor22 = uploadTinyDoor( TinyDoor(
            "23",
            "Tiny Door #6: Swan House Door",
            MarkerPoints.marker23.latitude,
            MarkerPoints.marker23.longitude
        ))

        var tinyDoor23 = uploadTinyDoor( TinyDoor(
            "24",
            "Tiny Door #5: Aquarium Door",
            MarkerPoints.marker24.latitude,
            MarkerPoints.marker24.longitude
        ))

        var tinyDoor24 = uploadTinyDoor( TinyDoor(
            "26",
            "Tiny Street!",
            MarkerPoints.tinyBusStop.latitude,
            MarkerPoints.tinyBusStop.longitude
        ))
    }

}