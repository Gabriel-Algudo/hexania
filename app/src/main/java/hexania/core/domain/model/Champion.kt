package hexania.core.domain.model

class Champion (
    val id : Int,
    val nom : String,
    val lore : String,
    val titre : String,
    val image : String,
    val pv :Int,
    val depl :Int,
    val prec : Double,
    val res : Double
){
    override fun toString(): String {
        return this.nom
    }
}