package com.example.atividade2

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.atividade2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val items = listOf("masculino", "feminino")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        binding.btcalcular.setOnClickListener{
            val idade = binding.resposta.text.toString().toInt()
            val sexo = binding.spinner.selectedItem as String
            val tempoRestante = if (sexo=="masculino") {
                65 - idade
            } else{
                62 - idade
            }
            binding.mensagem.text = "Faltam $tempoRestante anos para você se aposentar"
        }
    }
}