package hexania.core.model.player

import hexania.core.model.arca.Arme
import hexania.core.model.arca.Armure
import hexania.core.model.arca.Compagnon
import hexania.core.model.arca.Relique

class PlayerBuilder private constructor(
    val nom : String ? = null,
    private val arme : Arme? = null,
    private val relique : Relique? = null,
    private val compagnon : Compagnon? = null,
    private val armure : Armure? = null


) : PlayerBuilderI {
    override fun reset() :PlayerBuilderI {
        return PlayerBuilder()
    }

    override fun setName(nom : String) : PlayerBuilderI{
        return PlayerBuilder(nom)
    }

    override fun setArme(): PlayerBuilderI {
        TODO("Not yet implemented")
    }

    override fun setRelique(): PlayerBuilderI {
        TODO("Not yet implemented")
    }

    override fun setCompagnon(): PlayerBuilderI {
        TODO("Not yet implemented")
    }

    override fun setArmure(): PlayerBuilderI {
        TODO("Not yet implemented")
    }

    override fun toPlayer(): Player {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        var string = "Player : [ "
        string += "Nom : $nom, "
        string += "Arme : $arme, "
        string += "Relique : $relique, "
        string += "Compagnon : $compagnon, "
        string += "Armure : $armure"
        return "$string ]"
    }

    companion object{
        fun newPlayerBuilder() : PlayerBuilderI{
            return PlayerBuilder()
        }
    }
}