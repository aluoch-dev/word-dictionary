package com.raywenderlich.android.words.data.words

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raywenderlich.android.words.data.words.local.LocalWord
import com.raywenderlich.android.words.data.words.local.WordDao

/**
 * Created by Aluoch on 10/11/2021.
 */
//Defines LocalWord as the only entity
@Database( entities = [LocalWord::class], version = 1)
abstract class AppDatabase :RoomDatabase() {
    //defines words as an abstract property to get an instance of WordDao
    abstract val words: WordDao
}