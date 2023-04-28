package com.example.appfilmes


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appCoresRGB.AddCorActivity
import com.example.appfilmes.adapter.AdapterCores
import com.example.appfilmes.databinding.ActivityAddcorBinding
import com.example.appfilmes.databinding.ActivityMainBinding
import com.example.appfilmes.model.Cor


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val bindingCor: ActivityAddcorBinding by lazy { ActivityAddcorBinding.inflate(layoutInflater) }
    private val listaCores: MutableList<Cor>  = mutableListOf()
    private val adapterCores : AdapterCores = AdapterCores(this, listaCores)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recyclerViewCores = binding.rcVWCores
        recyclerViewCores.layoutManager = LinearLayoutManager(this)
        recyclerViewCores.setHasFixedSize(true)
        recyclerViewCores.adapter = adapterCores


        val swipe = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or
                    ItemTouchHelper.DOWN,
            ItemTouchHelper.END or
                    ItemTouchHelper.START
            ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition
                adapterCores.notifyItemMoved(fromPosition,toPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                listaCores.removeAt(viewHolder.adapterPosition)
                adapterCores.notifyDataSetChanged()
            }

        }
        val itemTouchHelper = ItemTouchHelper(swipe)
        itemTouchHelper.attachToRecyclerView(recyclerViewCores)

        binding.btAdd.setOnClickListener {
            val paraTelaDeCor = Intent(this, AddCorActivity::class.java )
            startActivity(paraTelaDeCor)
        }

        bindingCor.adicionar.setOnClickListener {
            val nome = bindingCor.etNomeCor.text.toString()
            val red = bindingCor.etRed.text.toString().toInt()
            val green = bindingCor.etGreen.text.toString().toInt()
            val blue = bindingCor.etBlue.text.toString().toInt()

            val cor = Cor(nome, Color.rgb(red, green, blue))

            listaCores.add(cor)
            adapterCores.notifyDataSetChanged()
            finish()

        }
    }

}


