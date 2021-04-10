package com.android.musicapplication.data.firebase

import com.android.musicapplication.data.entities.Song
import com.android.musicapplication.utils.Constants.COLLECTION_PATH
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {
    private val firestore = FirebaseFirestore.getInstance()
    private val songCollections = firestore.collection(COLLECTION_PATH)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollections.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

}