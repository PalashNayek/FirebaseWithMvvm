package com.example.firebasewithmvvm.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebasewithmvvm.model.AddNote
import com.example.firebasewithmvvm.utils.NetworkResult
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AddToDataRealtimeDBViewModel @Inject constructor(private val firebaseDatabase: FirebaseDatabase) :
    ViewModel() {

    private val _realtime = MutableLiveData<String>()
    val realtimeDBResponse = _realtime

    fun addDataToRealtimeDB(noteName: String, noteDesc: String) {

        val realtimeDBRef = firebaseDatabase.getReference("All Notes")
        val noteId = realtimeDBRef.push().key
        val addNote = noteId?.let { AddNote(it,noteName, noteDesc) }
        if (noteId != null) {
            realtimeDBRef.child(noteId).child("notes").setValue(addNote).addOnSuccessListener {
                _realtime.value = "Data saved successful"
            }.addOnFailureListener {
                _realtime.value = "Data saved failure"
            }
        }
    }
}