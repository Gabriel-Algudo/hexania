package hexania.core.vue

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import hexania.core.R
import hexania.core.model.character.Champion
import java.io.File

class CardViewHolder (private val view : View) : RecyclerView.ViewHolder(view) {

    fun bindViewItem(item : Champion){
        val nom = view.findViewById<TextView>(R.id.card_nom)
        val pv = view.findViewById<TextView>(R.id.card_pv)
        val titre = view.findViewById<TextView>(R.id.card_titre)
        val image = view.findViewById<ImageView>(R.id.card_image)
        val depl = view.findViewById<TextView>(R.id.card_depl)
        val prec = view.findViewById<TextView>(R.id.card_prec)
        val res = view.findViewById<TextView>(R.id.card_res)

        nom.text = item.nom
        pv.text = item.pv.toString()
        titre.text = item.titre
        image.load("file:///android_asset/characters/img/${item.nom}.png")
        //println("Pb d'image ????" + File("file:///android_asset/characters/img/${item.nom}.png"))
        depl.text = item.depl.toString()
        prec.text = item.prec.toString()
        res.text = item.res.toString()
    }
}