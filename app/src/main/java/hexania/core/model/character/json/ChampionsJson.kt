package hexania.core.model.character.json

import android.annotation.SuppressLint
import hexania.core.model.character.Champion
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class ChampionsJson (val characters : Array<ChampionJson>) {

    fun toChampion () : MutableList<Champion>{
        val mut : MutableList<Champion> = mutableListOf()
        for (champ in characters){
            mut.add(champ.toChampion())
        }
        return mut
    }

}