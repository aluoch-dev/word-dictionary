package com.raywenderlich.android.words.data.words.local;

import java.lang.System;

/**
 * Created by Aluoch on 10/11/2021.
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0011\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/raywenderlich/android/words/data/words/local/WordStore;", "", "database", "Lcom/raywenderlich/android/words/data/words/AppDatabase;", "(Lcom/raywenderlich/android/words/data/words/AppDatabase;)V", "words", "Lcom/raywenderlich/android/words/data/words/local/WordDao;", "all", "", "Lcom/raywenderlich/android/words/data/words/Word;", "isEmpty", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class WordStore {
    private final com.raywenderlich.android.words.data.words.local.WordDao words = null;
    
    public WordStore(@org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.words.data.words.AppDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.raywenderlich.android.words.data.words.Word> all() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object save(@org.jetbrains.annotations.NotNull()
    java.util.List<com.raywenderlich.android.words.data.words.Word> words, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isEmpty(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
}