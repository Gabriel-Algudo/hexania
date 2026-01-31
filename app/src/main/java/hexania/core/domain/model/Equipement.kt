package hexania.core.domain.model

import java.io.File

abstract class Equipement (
    private val id : Int,
    public val nom : String,
    public val image : File

){
    abstract fun use()
}