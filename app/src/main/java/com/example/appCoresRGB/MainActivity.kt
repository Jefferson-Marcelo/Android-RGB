package com.example.appfilmes


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfilmes.adapter.AdapterCores
import com.example.appfilmes.databinding.ActivityMainBinding
import com.example.appfilmes.model.Cores


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val listaCores: MutableList<Cores>  = mutableListOf()
    private val adapterCores : AdapterCores = AdapterCores(this, listaCores)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recyclerViewCores = binding.rcVWCores
        recyclerViewCores.layoutManager = LinearLayoutManager(this)
        recyclerViewCores.setHasFixedSize(true)
        recyclerViewCores.adapter = adapterCores
        //coresDaLista()

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
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Nova cor")


            val input = EditText(this)
            input.inputType = InputType.TYPE_CLASS_TEXT
            builder.setView(input)

            builder.setPositiveButton("Adicionar") { dialog, _ ->
                val novaCor = Cores(input.text.toString())
                listaCores.add(novaCor)
                adapterCores.notifyDataSetChanged()
                dialog.dismiss()
            }

            builder.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.cancel()
            }
            builder.show()
        }
    }

}

/*
    private fun coresDaLista(){
        val cor1 = Cores("Marrom")
        listaCores.add(cor1)
        val cor2 = Cores("rosa")
        listaCores.add(cor2)
        val cor3 = Cores("Verde")
        listaCores.add(cor3)
        val cor4 = Cores("Azul")
        listaCores.add(cor4)
        val cor5 = Cores("Amarelo")
        listaCores.add(cor5)
        val cor6 = Cores("Preto")
        listaCores.add(cor6)

    }

    fun add(){

        val builder = AlertDialog.Builder(this).apply {
            setTitle("Novo Nome!")
            setMessage("Digite o novo nome")
            setView(this@MainActivity.etNome)
            setPositiveButton("Salvar", OnClick())
            setNegativeButton("Cancelar", null)
        }
        builder.create().show()
    }

    inner class OnClick: DialogInterface.OnClickListener {
        override fun onClick(dialog: DialogInterface?, which: Int) {
            val nome = this@MainActivity.etNome.text.toString()
            (this@MainActivity.rvNomes.adapter as MyAdapter).add(nome)
        }
    }
*/