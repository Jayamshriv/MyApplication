package com.example.myapplication.data

import retrofit2.http.GET

interface ApiService {

    @GET("/en/characters/")
    suspend fun fetchCharacters() : CharacterModel

}