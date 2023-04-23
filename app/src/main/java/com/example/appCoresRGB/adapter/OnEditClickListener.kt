package com.example.appfilmes.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appfilmes.databinding.ActivityCoresItemBinding

class DetalhesCorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCoresItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtém os dados da cor selecionada do Intent
        val titulo = intent.getStringExtra("cor_titulo")
        //val descricao = intent.getStringExtra("cor_descricao")

        // Preenche o formulário com os dados da cor selecionada
        binding.txtNomeCor.text = titulo
       // binding.txtDescricao.text = descricao
    }
}