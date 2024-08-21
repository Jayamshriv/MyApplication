package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.ApiService
import com.example.myapplication.data.CharacterModel
import com.example.myapplication.data.CharacterModelItem
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
    private val _characters = MutableLiveData<CharacterModel>()
    val characters: LiveData<CharacterModel> get() = _characters

    private val _character = MutableLiveData<CharacterModelItem>(null)
    val character: MutableLiveData<CharacterModelItem> get() = _character

    fun fetchCharactersByIndex(index: Int) {
        viewModelScope.launch {
            try {
                _character.value = apiService.fetchCharactersByIndex(index)
            } catch (e: Exception) {
                // Handle exceptions
            }
        }
    }


    private fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val result = apiService.fetchCharacters()
                _characters.postValue(result)
            } catch (e: Exception) {
                Log.e("@@@",e.message.toString())
            }
        }
    }

}