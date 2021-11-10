package com.raywenderlich.android.words.data.words

import com.raywenderlich.android.words.data.words.local.WordStore
import com.raywenderlich.android.words.data.words.remote.WordSource

/**
 * Created by Aluoch on 28/10/2021.
 */

class WordRepository (
    private val wordSource: WordSource,
    //For ensureIsNotEmpty(populates db in WordStore if empty) to work, we add WordStore as a constructor property
    private val wordStore: WordStore,
    ) {

    //for convenience, we add a secondary constructor . Receives the db which is then sued to create WordStore
    constructor(database: AppDatabase): this(
        wordSource = WordSource(),
        wordStore = WordStore(database),
    )

    //calling ensureIsNotEmpty before calling all function to make sure the store has data
    suspend fun allWords() : List<Word> =
        wordStore.ensureIsNotEmpty().all()

    private suspend fun  WordStore.ensureIsNotEmpty() = apply{
        if(isEmpty()){
            val words = wordSource.load()
            save(words)
        }
    }

}

