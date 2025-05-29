package hexania.core.domain.model

class Arme (
    val id : Int,
    val nom : String,
    val cout : Int,
    val type : String,
    val image : String,
){
    override fun toString(): String {
        return this.nom
    }
}