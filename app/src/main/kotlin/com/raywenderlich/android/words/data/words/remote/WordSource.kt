package com.raywenderlich.android.words.data.words.remote

import com.raywenderlich.android.words.data.words.AppHttpClient
import com.raywenderlich.android.words.data.words.Word
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Aluoch on 28/10/2021.
 */

class WordSource (
    private val client: HttpClient = AppHttpClient //Making AppHttpClient the default value for HttpClient
        ){
    suspend fun load() :List<Word> = withContext(Dispatchers.IO) {
        client.getRemoteWords() //extension function
            .lineSequence()
            .map { Word(it)}
            .toList()
    }

    // the extension function executes a network GET request on an HTTP client
    private suspend fun HttpClient.getRemoteWords(): String =
        get("https://pablisco.com/define/words")

}