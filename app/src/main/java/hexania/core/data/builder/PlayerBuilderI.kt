package hexania.core.data.builder

import hexania.core.domain.model.Champion
import hexania.core.domain.model.Player

interface PlayerBuilderI {

    fun reset() : PlayerBuilderI

    fun setName(nom : String) : PlayerBuilderI

    fun setChampion(champion : Champion) : PlayerBuilderI

    fun setArme() :PlayerBuilderI

    fun setRelique() :PlayerBuilderI

    fun setCompagnon() :PlayerBuilderI

    fun setArmure() :PlayerBuilderI

    fun toPlayer() : Player
}