package hexania.core.ui.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import hexania.core.R
import hexania.core.domain.model.Champion
import hexania.core.exception.OnClickException

class CardViewHolder (
    private val viewOfItem : View,
    private val itemClickListener: CardClickListener,
    private val listeChamp : MutableList<Champion>
) :
    RecyclerView.ViewHolder(viewOfItem) {

    //CardView en elle même, voir card_view.xml (viewOfItem correspond au ConstrainteLayout et pas à la cardView)
    private val cardView = viewOfItem.findViewById<androidx.cardview.widget.CardView>(R.id.cardView)

    private val nom = viewOfItem.findViewById<TextView>(R.id.card_nom)
    private val pv = viewOfItem.findViewById<TextView>(R.id.card_pv)
    private val titre = viewOfItem.findViewById<TextView>(R.id.card_titre)
    private val image = viewOfItem.findViewById<ImageView>(R.id.card_image)
    private val depl = viewOfItem.findViewById<TextView>(R.id.card_depl)
    private val prec = viewOfItem.findViewById<TextView>(R.id.card_prec)
    private val res = viewOfItem.findViewById<TextView>(R.id.card_res)

    init {
        cardView.setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val champion = listeChamp[position]
                itemClickListener.onCardClick(champion)
            } else {
                throw OnClickException("Invalid position")
            }
        }
    }

    fun bindViewItem(item : Champion){
        nom.text = item.nom
        pv.text = item.pv.toString()
        titre.text = item.titre
        image.load("file:///android_asset/characters/img/${item.image}.png")
        //println("Pb d'image ????" + File("file:///android_asset/characters/img/${item.nom}.png"))
        depl.text = item.depl.toString()
        prec.text = item.prec.toString()
        res.text = item.res.toString()
    }
}