package com.example.firebasewithmvvm.di

import android.app.Application
import com.example.firebasewithmvvm.repository.FirebaseRepository
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideDatabaseReference(): DatabaseReference {
        return FirebaseDatabase.getInstance().reference
    }

    @Singleton
    @Provides
    fun provideFirebaseRepository(databaseReference: DatabaseReference): FirebaseRepository {
        return FirebaseRepository(databaseReference)
    }
}