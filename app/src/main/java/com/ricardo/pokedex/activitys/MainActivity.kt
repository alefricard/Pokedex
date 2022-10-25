package com.ricardo.pokedex.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ricardo.pokedex.R
import com.ricardo.pokedex.adapter.PokeAdapter
import com.ricardo.pokedex.databinding.ResActivityMainBinding
import com.ricardo.pokedex.databinding.ResPokemonItemBinding

class MainActivity : AppCompatActivity() {

    private lateinit var pokeAdapter: PokeAdapter
    private  lateinit var binding: ResActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ResActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        this.pokeAdapter = PokeAdapter()



    }
}