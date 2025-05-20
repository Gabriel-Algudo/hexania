package hexania.core.data.source

import hexania.core.domain.model.Champion
import kotlinx.serialization.Serializable
import java.text.Normalizer

@Serializable
data class ChampionJson(
    val id : Int,
    val nom : String,
    val lore : String,
    val titre : String,
    val image : String? = null,
    val pv :Int,
    val depl :Int,
    val prec : Double,
    val res : Double)
    {

    fun toChampion() : Champion {
        var img = this.image
        if (img == null){
            img = nettoyerChaine(this.nom)
        }
        return Champion(
            this.id,
            this.nom,
            this.lore,
            this.titre,
            img,
            this.pv,
            this.depl,
            this.prec,
            this.res
        )
    }

    internal fun nettoyerChaine(input: String): String {
        // Normalisation Unicode pour enlever les accents
        val sansAccents = Normalizer.normalize(input, Normalizer.Form.NFD)
            .replace(Regex("\\p{InCombiningDiacriticalMarks}+"), "")

        // Suppression ou remlpacement des caractères ne faisant pas partie de l'alphabet
        val sansCaracteres = sansAccents.replace("-", "").replace("'", "").replace(" ", "").replace("π","py").replace(".","").replace("1","l")

        // Conversion en minuscules
        return sansCaracteres.lowercase()
    }
}