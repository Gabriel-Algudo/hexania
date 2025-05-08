package hexania.core.model.character

import android.content.Context
import hexania.core.model.character.json.ChampionJson
import hexania.core.model.character.json.ChampionsJson
import hexania.core.model.character.json.JsonConversionException
import hexania.core.model.character.json.LectureJsonException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.json.JSONException
import java.io.File

class Champion (
    val id : Int,
    val nom : String,
    val lore : String,
    val titre : String,
    val pv :Int,
    val depl :Int,
    val prec : Double,
    val res : Double) {


    companion object{

        private val champions = mutableListOf<Champion>()

        fun getAllCharacters(context : Context) : MutableList<Champion>{
            if(champions.isEmpty()){
                try {
                    val extractFromFile = context.assets.open("characters/characters.json").bufferedReader().use { it.readText() }
                    //println(extractFromFile)

                    val listChampionJson = Json.decodeFromString<ChampionsJson>(extractFromFile)
                    val listChampion = listChampionJson.toChampion()

                    champions.addAll(listChampion)

                } catch (jsonException : JSONException){
                    throw JsonConversionException("Le contenu du fichier characters.json n'est pas convertissable en champions : ${jsonException.message}")
                } catch (e : Exception) {
                    throw LectureJsonException("Le fichier characters.json n'a pas réussi a être ouvert pour récupérer tous les personnages : ${e.message}")
                }
            }
            return champions
        }
    }
}