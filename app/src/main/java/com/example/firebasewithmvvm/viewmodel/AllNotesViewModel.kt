package com.example.firebasewithmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.firebasewithmvvm.model.NoteModel
import com.example.firebasewithmvvm.repository.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AllNotesViewModel @Inject constructor(private val firebaseRepository: FirebaseRepository) :
    ViewModel() {
    fun getAllNotes(): LiveData<List<NoteModel>> {
        return firebaseRepository.getAllNotes()
    }
}