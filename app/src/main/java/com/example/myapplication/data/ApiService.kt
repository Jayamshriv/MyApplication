package com.example.myapplication.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/en/characters/")
    suspend fun fetchCharacters() : CharacterModel

    @GET("/en/characters/")
    suspend fun fetchCharactersByIndex(
        @Query("index") index: Int
    ) : CharacterModelItem

}