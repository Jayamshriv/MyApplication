package com.example.myapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.CharacterModel
import com.example.myapplication.databinding.CharacterItemBinding
import javax.inject.Inject

class CharacterRecyclerViewAdapter : RecyclerView.Adapter<CharacterRecyclerViewAdapter.CharacterViewHolder>() {


    var characterList = CharacterModel()
    fun fetchCharacter(
        characterList : CharacterModel
    ){
        this.characterList = characterList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val items = characterList[position]
        holder.binding.apply {
            Glide
                .with(imageCharacter)
                .load(items.image)

            nameCharacter.text = items.fullName
        }
    }

    override fun getItemCount(): Int {
        return characterList.size
    }


    inner class CharacterViewHolder(val binding : CharacterItemBinding) : RecyclerView.ViewHolder(binding.root){

    }
}