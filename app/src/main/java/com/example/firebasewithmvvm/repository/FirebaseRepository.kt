package com.example.firebasewithmvvm.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firebasewithmvvm.model.NoteModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

class FirebaseRepository @Inject constructor(private val databaseReference: DatabaseReference) {

    fun saveUser(note: NoteModel) {
        databaseReference.child("notes").push().setValue(note)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        val liveData = MutableLiveData<List<NoteModel>>()
        databaseReference.child("notes").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val noteList = mutableListOf<NoteModel>()
                for (noteSnapshot in snapshot.children) {
                    val note = noteSnapshot.getValue(NoteModel::class.java)
                    if (note != null) {
                        noteList.add(note)
                    }
                }
                liveData.value = noteList
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("FirebaseRepository", "Failed to get users: ${error.message}")
            }
        })
        return liveData
    }
}
