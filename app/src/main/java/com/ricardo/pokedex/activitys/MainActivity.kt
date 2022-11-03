package com.ricardo.pokedex.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ricardo.pokedex.adapter.PokeAdapter
import com.ricardo.pokedex.databinding.ResActivityMainBinding
import com.ricardo.pokedex.domain.Pokemon
import com.ricardo.pokedex.viewmodel.PokemonViewModel
import com.ricardo.pokedex.viewmodel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ResActivityMainBinding
    lateinit var recyclerView: RecyclerView

    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())[PokemonViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ResActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        recyclerView = binding.rvPokemons

        viewModel.pokemons.observe(this, Observer {
            initRecyclerView(it)
        })
    }

    private fun initRecyclerView(pokemons: List<Pokemon?>) {

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokeAdapter(pokemons as List<Pokemon>)

    }
}