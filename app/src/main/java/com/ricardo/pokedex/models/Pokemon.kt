package com.ricardo.pokedex.models

data class Pokemon(
    val imagemUrl: String,
    val number: Int,
    val name: String,
    val types: List<PokemonType>
)

