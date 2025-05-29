package hexania.core.data.repository

import hexania.core.Hexania
import hexania.core.data.json.ChampionJson
import hexania.core.domain.model.Champion
import hexania.core.exception.NotFoundException
import hexania.core.exception.JsonConversionException
import hexania.core.exception.LectureJsonException
import kotlinx.serialization.json.Json
import org.json.JSONException

class ChampionRepository() {
    private val allChampions : MutableList<Champion> = mutableListOf<Champion>()

    fun getAllChampions() : MutableList<Champion>{
        if(this.allChampions.isEmpty()){
            try {
                val context = Hexania.Companion.applicationContext()
                val extractFromFile = context.assets.open("characters/champions.json").bufferedReader().use { it.readText() }
                //println(extractFromFile)

                val listChampionJson = Json.Default.decodeFromString<List<ChampionJson>>(extractFromFile)
                for (champion in listChampionJson){
                    allChampions.add(champion.toChampion())
                }

            } catch (jsonException : JSONException){
                throw JsonConversionException("Le contenu du fichier champions.json n'est pas convertissable en champions : ${jsonException.message}")
            } catch (e : Exception) {
                throw LectureJsonException("Le fichier champions.json n'a pas réussi a être ouvert pour récupérer tous les personnages : ${e.message}")
            }
        }
        return allChampions
    }

    fun getChampionByName(name : String) : Champion {
        if (allChampions.isEmpty()){
            getAllChampions()
        }
        val champ = allChampions.find({
            it.nom == name
        })
        if (champ == null){
            throw NotFoundException("Le personnage $name n'a pas été trouvé")
        }
        return champ
    }

    fun getChampionById(id : Int) : Champion {
        if (allChampions.isEmpty()){
            getAllChampions()
        }
        val champ = allChampions.find({
            it.id == id
        })
        if (champ == null){
            throw NotFoundException("Le personnage $id n'a pas été trouvé")
        }
        return champ
    }
}