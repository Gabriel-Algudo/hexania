package hexania.core.data.builder

import hexania.core.domain.model.Champion
import hexania.core.domain.model.Party
import hexania.core.data.builder.PlayerBuilderI

interface PartyBuilderI {

    fun reset(): PartyBuilderI

    fun addPlayer()

    fun setNameToPlayer(name: String, index : Int)

    fun setChampionToPlayer(champion: Champion, index : Int)

    fun setArme()

    fun setRelique()

    fun setCompagnon()

    fun setArmure()

    fun build() : Party

    fun getAllPlayer(): MutableList<PlayerBuilderI>
}