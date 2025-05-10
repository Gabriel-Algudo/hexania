package hexania.core.model.party

import hexania.core.model.character.Champion
import hexania.core.model.player.PlayerBuilder
import hexania.core.model.player.PlayerBuilderI

interface PartyBuilderI {

    fun reset(): PartyBuilderI

    fun addAllPlayer(playerList : MutableList<PlayerBuilderI>)

    fun setName(namelist : MutableList<String>)

    fun setChampions(championList : MutableList<Champion>)

    fun setArme()

    fun setRelique()

    fun setCompagnon()

    fun setArmure()

    fun build() : Party
}