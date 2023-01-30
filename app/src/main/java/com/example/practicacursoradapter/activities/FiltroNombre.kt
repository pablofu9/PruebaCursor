package com.example.practicacursoradapter.activities

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.example.practicacursoradapter.R
import com.example.practicacursoradapter.controller.PersonaAdapter
import com.example.practicacursoradapter.controller.SqliteHelper

class FiltroNombre : AppCompatActivity(), View.OnClickListener {

    private lateinit var editNombre:EditText
    private lateinit var editApellido:EditText
    private lateinit var btnFiltrar:Button
    private lateinit var listaNombre:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filtro_nombre)

        editNombre=findViewById(R.id.editNombre)
        editApellido=findViewById(R.id.editApellido)
        btnFiltrar=findViewById(R.id.btnFiltrar)
        listaNombre=findViewById(R.id.listaNombre)

        btnFiltrar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val helper=SqliteHelper(this)
        val c : Cursor=helper.leerNombre(editNombre.text.toString(), editApellido.text.toString())

        val adapter = PersonaAdapter(this, c, 0)
        listaNombre.adapter=adapter
    }
}