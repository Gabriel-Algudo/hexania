package hexania.core.model.party

import hexania.core.model.character.Champion
import hexania.core.model.player.PlayerBuilder
import hexania.core.model.player.PlayerBuilderI

interface PartyBuilderI {

    fun reset(): PartyBuilderI

    fun addPlayer(playerBuilder : PlayerBuilderI) :PartyBuilderI

    fun setName(namelist : MutableList<String>) :PartyBuilderI

    fun setChampions(championList : MutableList<Champion>) :PartyBuilderI

    fun setArme() :PartyBuilderI

    fun setRelique() :PartyBuilderI

    fun setCompagnon() :PartyBuilderI

    fun setArmure() :PartyBuilderI
}