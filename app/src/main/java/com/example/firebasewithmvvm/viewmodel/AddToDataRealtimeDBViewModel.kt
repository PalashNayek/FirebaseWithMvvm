package com.example.firebasewithmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebasewithmvvm.model.NoteModel
import com.example.firebasewithmvvm.repository.FirebaseRepository
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddToDataRealtimeDBViewModel @Inject constructor(private val firebaseRepository: FirebaseRepository) :
    ViewModel() {

    fun saveNotes(note: NoteModel) {
        firebaseRepository.saveUser(note)
    }
}