package hexania.core.data.json

import hexania.core.domain.model.Arme
import kotlinx.serialization.Serializable

@Serializable
data class ArmeJson (
    val id : Int,
    val nom : String,
    val cout : Int,
    val type : String,
    val portee : Int,
    val image : String? = null,
){

    fun toArme() : Arme {
        var img = this.image
        if (img == null){
            img = nettoyerChaine(this.nom)
        }
        return Arme(
            this.id,
            this.nom,
            this.cout,
            this.type,
            img)
    }
}