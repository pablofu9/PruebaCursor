package com.example.practicacursoradapter.activities

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.example.practicacursoradapter.R
import com.example.practicacursoradapter.controller.PersonaAdapter
import com.example.practicacursoradapter.controller.SqliteHelper
import com.example.practicacursoradapter.model.Persona
import com.example.practicacursoradapter.model.PersonaContract

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnVer:Button
    private lateinit var btnInsertar:Button
    private lateinit var btnEdad:Button
    private lateinit var btnNombre:Button
    private lateinit var btnCodigo:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnVer=findViewById(R.id.btnVer)
        btnInsertar=findViewById(R.id.btnInsertar)
        btnEdad=findViewById(R.id.btnEdad)
        btnNombre=findViewById(R.id.btnNombre)
        btnCodigo=findViewById(R.id.btnCodigo)

        btnVer.setOnClickListener(this)
        btnInsertar.setOnClickListener(this)
        btnEdad.setOnClickListener(this)
        btnNombre.setOnClickListener(this)
        btnCodigo.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.btnVer->{

                var intent = Intent(this, Ver::class.java)
                startActivity(intent)
            }
            R.id.btnInsertar->{
                var intent = Intent(this, Insertar::class.java)
                startActivity(intent)
            }
            R.id.btnEdad->{
                var intent = Intent(this, FiltroEdad::class.java)
                startActivity(intent)
            }
            R.id.btnNombre->{
                var intent = Intent(this, FiltroNombre::class.java)
                startActivity(intent)
            }
            R.id.btnCodigo->{
                var intent = Intent(this, Ver::class.java)
                startActivity(intent)
            }
        }
    }


}