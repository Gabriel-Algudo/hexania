package hexania.core.domain.model

import java.io.File

class Arme (
    id : Int,
    nom : String,
    val cout : Int,
    val type : TypeArme,
    image : File,
) : Equipement(id, nom, image){

    override fun use (cible : Champion) {
        TODO("faire les use() ")
    }

    override fun toString(): String {
        return this.nom
    }
}