package com.raywenderlich.android.words.data.words.local

import androidx.paging.*
import androidx.room.RoomDatabase
import com.raywenderlich.android.words.data.words.AppDatabase
import com.raywenderlich.android.words.data.words.Word
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow

/**
 * Created by Aluoch on 10/11/2021.
 */
class WordStore (
    database: AppDatabase
        ) {
    //saves an internal instance of WordDao as words
    private val words = database.words

    fun all(): Flow<PagingData<Word>> = pagingWord { words.queryAll() }

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

private fun pagingWord(
    block: () -> PagingSource<Int, LocalWord>,
): Flow<PagingData<Word>> =
    Pager(PagingConfig(pageSize = 20)) { block() }.flow
        .map { page -> page.map { localWord -> localWord.fromLocal() } }
