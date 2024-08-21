package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.ApiService
import com.example.myapplication.data.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val apiService: ApiService
): ViewModel() {

    init {
        fetchCharacters()
    }
    var characters = CharacterModel()

    private fun fetchCharacters() {
        viewModelScope.launch {
             characters =  apiService.fetchCharacters()
        }
    }

}