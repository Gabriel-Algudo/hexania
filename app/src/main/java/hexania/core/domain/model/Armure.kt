package hexania.core.domain.model

import java.io.File

class Armure(
    id :Int,
    nom :String,
    image :File,
    public val defense : Int
) : Equipement(id, nom, image){

    override fun use() {
        TODO("Not yet implemented")
    }
}