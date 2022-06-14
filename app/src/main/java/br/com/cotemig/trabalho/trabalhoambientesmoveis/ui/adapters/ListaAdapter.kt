package br.com.cotemig.trabalho.trabalhoambientesmoveis.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.trabalho.trabalhoambientesmoveis.R
import br.com.cotemig.trabalho.trabalhoambientesmoveis.models.Cerveja
import coil.load

class ListaAdapter (var context: Context, var list: List<Cerveja>) : BaseAdapter(){
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

        var view = LayoutInflater.from(context).inflate(R.layout.item_lista, null)

        var name = view.findViewById<TextView>(R.id.name)
        name.text = list[position].name

        var image = view.findViewById<ImageView>(R.id.image)
        image.load(list[position].image)

        return view
    }
}