package com.example.appfilmes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appfilmes.databinding.ActivityCoresItemBinding
import com.example.appfilmes.model.Cor

class AdapterCores(private val context: Context, private val listaCores: MutableList<Cor>):
    RecyclerView.Adapter<AdapterCores.CorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CorViewHolder {
        val itemLista = ActivityCoresItemBinding.inflate(LayoutInflater.from(context),parent, false)
        return CorViewHolder(itemLista)
    }

    override fun getItemCount() = listaCores.size

    override fun onBindViewHolder(holder: CorViewHolder, position: Int) {
        holder.txtNomeCor.text = listaCores[position].Nome

    }

    inner class CorViewHolder(binding: ActivityCoresItemBinding):
        RecyclerView.ViewHolder(binding.root){
            val txtNomeCor = binding.txtNomeCor
    }
}