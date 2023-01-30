package com.example.practicacursoradapter.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.practicacursoradapter.R
import com.example.practicacursoradapter.controller.SqliteHelper
import com.example.practicacursoradapter.model.Persona

class Insertar : AppCompatActivity(), View.OnClickListener {
    private lateinit var edNombre:EditText
    private lateinit var edApellido:EditText
    private lateinit var edAltura:EditText
    private lateinit var edEdad:EditText
    private lateinit var btnInsertar:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar)

        edNombre=findViewById(R.id.edNombre)
        edApellido=findViewById(R.id.edApellido)
        edAltura=findViewById(R.id.edAltura)
        edEdad=findViewById(R.id.edEdad)
        btnInsertar=findViewById(R.id.btnInsertar)

        btnInsertar.setOnClickListener(this)
        if(intent.hasExtra("p")){
            val p = intent.getSerializableExtra("p") as Persona
            edNombre.setText(p.nombre)
            edApellido.setText(p.apellido)
            edAltura.setText(p.altura.toString())
            edEdad.setText(p.edad.toString())
        }
    }

    override fun onClick(v: View?) {
            val helper=SqliteHelper(this)
            if(intent.hasExtra("p")){
                val p = intent.getSerializableExtra("p") as Persona
                val persona:Persona=Persona(p._id,edNombre.text.toString(),edApellido.text.toString(),edAltura.text.toString().toInt(),edEdad.text.toString().toInt())
                helper.modificar(persona)
                println(persona.nombre)
            }else{
                val p:Persona=Persona(edNombre.text.toString(),edApellido.text.toString(),edAltura.text.toString().toInt(),edEdad.text.toString().toInt())
                helper.insertar(p)
            }

    }
}