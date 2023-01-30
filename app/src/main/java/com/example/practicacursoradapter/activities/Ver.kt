package com.example.practicacursoradapter.activities

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ListView
import com.example.practicacursoradapter.R
import com.example.practicacursoradapter.controller.PersonaAdapter
import com.example.practicacursoradapter.controller.SqliteHelper
import com.example.practicacursoradapter.model.Persona

class Ver : AppCompatActivity() {
    private lateinit var lista:ListView
    private lateinit var adapter:PersonaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver)

        lista=findViewById(R.id.lista)
        cargar()
        registerForContextMenu(lista)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        menuInflater.inflate(R.menu.menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterContextMenuInfo
        when(item.itemId){
            R.id.menuEliminar->{
                val c: Cursor=adapter.getItem(info.position) as Cursor
                val helper=SqliteHelper(this)
                var p:Persona=helper.devolverPersona(c)
                helper.eliminar(p)
                cargar()

            }
            R.id.menuModificar->{
                val c: Cursor=adapter.getItem(info.position) as Cursor
                val helper=SqliteHelper(this)
                var p:Persona=helper.devolverPersona(c)
                val intent=Intent(this,Insertar::class.java)
                intent.putExtra("p",p)
                startActivity(intent)
            }
        }

        return super.onContextItemSelected(item)
    }
    fun cargar(){
        val helper=SqliteHelper(this)
        val c:Cursor=helper.leer()

        adapter = PersonaAdapter(this, c, 0)
        lista.adapter=adapter
    }
}