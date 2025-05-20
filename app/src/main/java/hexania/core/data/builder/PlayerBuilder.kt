package hexania.core.data.builder

import hexania.core.domain.model.Arme
import hexania.core.domain.model.Armure
import hexania.core.domain.model.Champion
import hexania.core.domain.model.Compagnon
import hexania.core.domain.model.Player
import hexania.core.domain.model.Relique
import hexania.core.data.builder.PlayerBuilderI

class PlayerBuilder private constructor(
    val nom : String ? = null,
    private val champion : Champion? = null,
    private val arme : Arme? = null,
    private val relique : Relique? = null,
    private val compagnon : Compagnon? = null,
    private val armure : Armure? = null


) : PlayerBuilderI {
    override fun reset() : PlayerBuilderI {
        return PlayerBuilder()
    }

    override fun setName(nom : String): PlayerBuilder {
        return PlayerBuilder(nom)
    }

    override fun setChampion(champion: Champion): PlayerBuilderI {
        return PlayerBuilder(this.nom, champion)
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
        string += "Champion : $champion, "
        string += "Arme : $arme, "
        string += "Relique : $relique, "
        string += "Compagnon : $compagnon, "
        string += "Armure : $armure"
        return "$string ]"
    }

    companion object{
        fun newPlayerBuilder() : PlayerBuilderI {
            return PlayerBuilder()
        }
    }
}