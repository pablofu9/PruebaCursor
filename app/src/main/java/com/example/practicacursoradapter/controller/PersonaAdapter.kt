package com.example.practicacursoradapter.controller

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.TextView
import com.example.practicacursoradapter.R
import com.example.practicacursoradapter.model.PersonaContract

class PersonaAdapter(context: Context, c:Cursor ,flags:Int):CursorAdapter(context, c, flags) {
    override fun newView(context: Context?, p1: Cursor?, p2: ViewGroup?): View {
        val inflater=LayoutInflater.from(context)
        val convertView = inflater.inflate(R.layout.item_persona, null)
        return convertView
    }

    override fun bindView(view: View?, context: Context?, cursor: Cursor?) {
        val txtId = view?.findViewById<TextView>(R.id.txtId)
        val txtNombre = view?.findViewById<TextView>(R.id.txtNombre)
        val txtApellido = view?.findViewById<TextView>(R.id.txtApellido)

        txtId?.text= cursor?.getInt(cursor.getColumnIndexOrThrow(PersonaContract.ID)).toString()
        txtNombre?.text=cursor?.getString(cursor.getColumnIndexOrThrow(PersonaContract.NOMBRE))
        txtApellido?.text=cursor?.getString(cursor.getColumnIndexOrThrow(PersonaContract.APELLIDO))
    }
}