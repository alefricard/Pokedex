package com.ricardo.pokedex.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ricardo.pokedex.adapter.PokeAdapter
import com.ricardo.pokedex.databinding.ResActivityMainBinding

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
        binding.rvPokemons.adapter = PokeAdapter()
        this.pokeAdapter = PokeAdapter()



    }
}