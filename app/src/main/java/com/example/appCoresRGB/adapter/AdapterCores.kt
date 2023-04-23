package com.example.appfilmes.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appfilmes.databinding.ActivityCoresItemBinding
import com.example.appfilmes.model.Cores

class AdapterCores(private val context: Context, private val listaCores: MutableList<Cores>):
    RecyclerView.Adapter<AdapterCores.CorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CorViewHolder {
        val itemLista = ActivityCoresItemBinding.inflate(LayoutInflater.from(context),parent, false)
        return CorViewHolder(itemLista)
    }

    override fun getItemCount() = listaCores.size

    override fun onBindViewHolder(holder: CorViewHolder, position: Int) {
        holder.txtNomeCor.text = listaCores[position].Nome
        /* holder.txtNomeCor.text = listaCores[position].Red.toString()
       holder.txtNomeCor.text = listaCores[position].Grenn.toString()
       holder.txtNomeCor.text = listaCores[position].Blue.toString()

       // Adiciona um listener de clique no ViewHolder
       holder.itemView.setOnClickListener {
           val corSelecionada = listaCores[position]

           // Cria um Intent para iniciar a nova atividade
           val intent = Intent(context, Cores::class.java)

           // Adiciona os dados da cor selecionada ao Intent
           intent.putExtra("cor_titulo", corSelecionada.titulo)
           //intent.putExtra("cor_descricao", corSelecionada.descricao)

           // Inicia a nova atividade
           context.startActivity(intent)
       }*/
    }

    inner class CorViewHolder(binding: ActivityCoresItemBinding):
        RecyclerView.ViewHolder(binding.root){
            val txtNomeCor = binding.txtNomeCor
    }


}