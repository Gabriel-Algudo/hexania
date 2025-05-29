package hexania.core.data.repository

import hexania.core.Hexania
import hexania.core.data.json.ArmeJson
import hexania.core.domain.model.Arme
import hexania.core.exception.JsonConversionException
import hexania.core.exception.LectureJsonException
import hexania.core.exception.NotFoundException
import kotlinx.serialization.json.Json
import org.json.JSONException

class ArmeRepository() {
    private val allArmes : MutableList<Arme> = mutableListOf<Arme>()

    fun getAllArmes() : MutableList<Arme>{
    if(this.allArmes.isEmpty()){
            try {
                val context = Hexania.Companion.applicationContext()
                val extractFromFile = context.assets.open("armes/armes.json").bufferedReader().use { it.readText() }
                //println(extractFromFile)

                val listArmesJson = Json.Default.decodeFromString<List<ArmeJson>>(extractFromFile)
                for (arme in listArmesJson){
                    allArmes.add(arme.toArme())
                }

            } catch (jsonException : JSONException){
                throw JsonConversionException("Le contenu du fichier armes.json n'est pas convertissable en arme : ${jsonException.message}")
            } catch (e : Exception) {
                throw LectureJsonException("Le fichier armes.json n'a pas réussi a être ouvert pour récupérer toutes les armes : ${e.message}")
            }
        }
        return allArmes
    }

    fun getArmeByName(name : String) : Arme {
        if (allArmes.isEmpty()){
            getAllArmes()
        }
        val arme = allArmes.find({
            it.nom == name
        })
        if (arme == null){
            throw NotFoundException("L'arme $name n'a pas été trouvé")
        }
        return arme
    }

    fun getArmeById(id : Int) : Arme {
        if (allArmes.isEmpty()){
            getAllArmes()
        }
        val arme = allArmes.find({
            it.id == id
        })
        if (arme == null){
            throw NotFoundException("L'arme $id n'a pas été trouvé")
        }
        return arme
    }
}