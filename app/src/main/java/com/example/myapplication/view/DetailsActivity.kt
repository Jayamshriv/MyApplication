package com.example.myapplication.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDetailsBinding
import com.example.myapplication.viewmodel.CharacterViewModel

class DetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val characterIndex = intent.getIntExtra("characterIndex", -1)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel : CharacterViewModel by viewModels()
        viewModel.fetchCharactersByIndex(characterIndex)
        viewModel.character.observe(this) { character ->
            Glide.with(this)
                .load(character?.image)
                .into(binding.imageCharacter)

            binding.fullName.text = character.fullName
            binding.nickname.text = "Nickname: ${character.nickname}"
            binding.hogwartsHouse.text = "House: ${character.hogwartsHouse}"
            binding.interpretedBy.text = "Interpreted By: ${character.interpretedBy}"
            binding.birthdate.text = "Birthdate: ${character.birthdate}"
            binding.children.text = "Children: ${character.children.joinToString(", ")}"
        }
    }
}