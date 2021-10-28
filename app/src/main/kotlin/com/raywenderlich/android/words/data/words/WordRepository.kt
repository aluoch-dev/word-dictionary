package com.raywenderlich.android.words.data.words

import com.raywenderlich.android.words.data.words.remote.WordSource

/**
 * Created by Aluoch on 28/10/2021.
 */
class WordRepository (
    private val wordSource: WordSource = WordSource()
    ) {

    suspend fun allWords() : List<Word> = wordSource.load()

}

