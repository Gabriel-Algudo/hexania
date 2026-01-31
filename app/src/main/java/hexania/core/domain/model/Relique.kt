package hexania.core.domain.model

import java.io.File

class Relique (
    id :Int,
    nom :String,
    val cout :Int,
    image : File,
    private val type : TypeRelique,
    private val utilisation : String,
    private val nbUtil :Int
) : Equipement(id, nom, image){

    override fun use() {
        TODO("Not yet implemented")
    }
}