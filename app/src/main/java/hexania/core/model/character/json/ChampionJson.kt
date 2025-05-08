package hexania.core.model.character.json

import android.annotation.SuppressLint
import hexania.core.model.character.Champion
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class ChampionJson(
    val id : Int,
    val nom : String,
    val lore : String,
    val titre : String,
    val pv :Int,
    val depl :Int,
    val prec : Double,
    val res : Double)
    {

    fun toChampion() :Champion{
        return Champion(this.id, this.nom, this.lore, this.titre, this.pv, this.depl, this.prec, this.res)
    }
}