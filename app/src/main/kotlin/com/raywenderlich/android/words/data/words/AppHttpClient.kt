package com.raywenderlich.android.words.data.words

import io.ktor.client.*

/**
 * Created by Aluoch on 28/10/2021.
 */

val AppHttpClient : HttpClient by lazy{
    HttpClient()
}
