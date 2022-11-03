package com.ricardo.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ricardo.pokedex.databinding.ResPokemonItemBinding
import com.ricardo.pokedex.domain.Pokemon

class PokeAdapter(
    private var items: List<Pokemon>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PokeViewHolder(
            ResPokemonItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
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

        private val ivPokemon = itemView.ivPokemon
        private val nome = itemView.tvName
        private val number = itemView.tvNumber
        private val type1 = itemView.tvType1
        private val type2 = itemView.tvType2


        fun bind(pokemon: Pokemon) {

            items.let {

                Glide.with(itemView.context).load(pokemon.imageUrl).into(ivPokemon)

                nome.text = pokemon.name
                number.text = "N° ${pokemon.formattedNumber}"
                type1.text = pokemon.types[0].name


                if (pokemon.types.size > 1) {
                    type2.visibility = View.VISIBLE
                    type2.text = pokemon.types[1].name
                } else {
                    type2.visibility = View.GONE
                }
            }


        }
    }

}