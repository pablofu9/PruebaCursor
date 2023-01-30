package com.example.practicacursoradapter.activities

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SeekBar
import android.widget.TextView
import com.example.practicacursoradapter.R
import com.example.practicacursoradapter.controller.PersonaAdapter
import com.example.practicacursoradapter.controller.SqliteHelper

class FiltroEdad : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var edadMin: SeekBar
    private lateinit var edadMax:SeekBar
    private lateinit var txtEdadMin: TextView
    private lateinit var txtEdadMax: TextView
    private lateinit var listaEdad : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filtro_edad)

        edadMin=findViewById(R.id.edadMin)
        edadMax=findViewById(R.id.edadMax)
        txtEdadMax=findViewById(R.id.txtEdadMax)
        txtEdadMin=findViewById(R.id.txtEdadMin)
        listaEdad=findViewById(R.id.listaEdad)

        edadMax.setOnSeekBarChangeListener(this)
        edadMin.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        txtEdadMin.text=edadMin.progress.toString()
        txtEdadMax.text=edadMax.progress.toString()
        cargarEdades(edadMin.progress,edadMax.progress)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }

    fun cargarEdades(e1:Int,e2:Int){
        val helper= SqliteHelper(this)
        val c:Cursor=helper.leerEdad(e1,e2)
        val adapter = PersonaAdapter(this, c, 0)
        listaEdad.adapter=adapter
    }
}