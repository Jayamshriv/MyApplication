package com.example.myapplication.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.CharacterModel
import com.example.myapplication.databinding.CharacterItemBinding
import com.example.myapplication.view.DetailsActivity
import javax.inject.Inject

class CharacterRecyclerViewAdapter(
    private val context : Context
) : RecyclerView.Adapter<CharacterRecyclerViewAdapter.CharacterViewHolder>() {
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
                .with(imageCharacter.context)
                .load(items.image)
                .into(imageCharacter)

            nameCharacter.text = items.fullName
            cv.setOnClickListener {
                val intent = Intent(context, DetailsActivity::class.java).apply {
                    putExtra("characterIndex", items.index)
                }
                context.startActivity(intent)
            }

        }
    }

    override fun getItemCount(): Int {
        return characterList.size
    }


    inner class CharacterViewHolder(val binding : CharacterItemBinding) : RecyclerView.ViewHolder(binding.root){

    }
}