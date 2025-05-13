package hexania.core.ui.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import hexania.core.R
import hexania.core.model.character.Champion
import java.text.Normalizer

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
        val fileName = nettoyerChaine(item.nom)
        image.load("file:///android_asset/characters/img/$fileName.png")
        //println("Pb d'image ????" + File("file:///android_asset/characters/img/${item.nom}.png"))
        depl.text = item.depl.toString()
        prec.text = item.prec.toString()
        res.text = item.res.toString()
    }
}


fun nettoyerChaine(input: String): String {
    // Normalisation Unicode pour enlever les accents
    val sansAccents = Normalizer.normalize(input, Normalizer.Form.NFD)
        .replace(Regex("\\p{InCombiningDiacriticalMarks}+"), "")

    // Suppression ou remlpacement des caractères ne faisant pas partie de l'alphabet
    val sansCaracteres = sansAccents.replace("-", "").replace("'", "").replace(" ", "").replace("π","py").replace(".","").replace("1","l")

    // Conversion en minuscules
    return sansCaracteres.lowercase()
}