package com.coolcats.tinydoorsscavengerhunts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.coolcats.tinydoorsscavengerhunts.model.TinyDoor

class TinyDoorViewModel(stateHandle: SavedStateHandle) : ViewModel() {

    var tinyDoorsList = MutableLiveData<TinyDoor>()

}