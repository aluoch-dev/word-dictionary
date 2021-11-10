package com.raywenderlich.android.words.data.words.local

import androidx.room.RoomDatabase
import com.raywenderlich.android.words.data.words.AppDatabase
import com.raywenderlich.android.words.data.words.Word

/**
 * Created by Aluoch on 10/11/2021.
 */
class WordStore (
    database: AppDatabase
        ) {
    //saves an internal instance of WordDao as words
    private val words = database.words

    //call all using WordDao to access LocalWord, then map converts them to plain words
    fun all(): List<Word> = words.queryAll().map{ it.fromLocal() }

    // takes a plain list of words using save, converts them to room values and saves them
    suspend fun save(words: List<Word>){
        this.words.insert(words.map { it.toLocal() })
    }

    //Determines if there are any saved words
    suspend fun  isEmpty(): Boolean = words.count() == 0L
}


//the mapper functions toLocal and fromLocal covert Word from and to LocalWord
private fun Word.toLocal() = LocalWord(
    value = value,
)

private fun LocalWord.fromLocal() = Word(
    value = value,
)
