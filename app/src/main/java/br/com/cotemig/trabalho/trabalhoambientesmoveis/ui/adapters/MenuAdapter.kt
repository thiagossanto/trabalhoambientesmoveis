package br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import br.com.cotemig.trabalho.trabalhoambientesmoveis.R
import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Menu

class MenuAdapter (var context: Context, var list: List<Menu>) : BaseAdapter(){

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_types, null)

        var type = view.findViewById<Button>(R.id.type)
        type.text = list[position].type

        return view
    }
}