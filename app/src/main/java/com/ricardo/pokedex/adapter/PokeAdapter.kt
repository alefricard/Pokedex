package com.ricardo.pokedex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ricardo.pokedex.databinding.ResPokemonItemBinding
import com.ricardo.pokedex.models.Pokemon

class PokeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items : List<Pokemon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PokeViewHolder(
        ResPokemonItemBinding.inflate(
            LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is PokeViewHolder -> {
                holder.bind(items[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class PokeViewHolder constructor(
        itemView : ResPokemonItemBinding
    ): RecyclerView.ViewHolder(itemView.root){

        private val imagePokemon = itemView.ivPokemon
        private val nome = itemView.tvName
        private val number = itemView.tvNumber
        private val type1 = itemView.tvType1


        fun bind(pokemon: Pokemon){

            nome.text = pokemon.name
            number.text = pokemon.number.toString()
            type1.text = pokemon.types.toString()
            imagePokemon.drawable


        }
    }

}