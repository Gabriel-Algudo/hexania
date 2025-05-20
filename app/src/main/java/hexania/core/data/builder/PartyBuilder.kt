package hexania.core.data.builder

import hexania.core.domain.model.Champion
import hexania.core.domain.model.Party
import hexania.core.data.builder.PlayerBuilder
import hexania.core.data.builder.PlayerBuilderI

//A remplacer par un object PartyBuilder (singleton)
class PartyBuilder private constructor(

    val players : MutableList<PlayerBuilderI> = mutableListOf<PlayerBuilderI>(),
    //private val board: Board? = null

): PartyBuilderI {
    override fun reset() : PartyBuilderI {
        return PartyBuilder()
    }

    override fun addPlayer() {
        players.add(PlayerBuilder.Companion.newPlayerBuilder())
    }

    override fun setNameToPlayer(name: String, index : Int) {
        players[index] = players[index].setName(name)
    }

    override fun setChampionToPlayer(champion: Champion, index : Int) {
        players[index] = players[index].setChampion(champion)
    }

    override fun setArme() {
        TODO("Not yet implemented")
    }

    override fun setRelique() {
        TODO("Not yet implemented")
    }

    override fun setCompagnon() {
        TODO("Not yet implemented")
    }

    override fun setArmure() {
        TODO("Not yet implemented")
    }

    override fun build() : Party {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        var string = "Party : ["
        players.forEach {
            string += "$it, "
        }
        return "$string ]"
    }

    override fun getAllPlayer() : MutableList<PlayerBuilderI>{
        return this.players
    }

    companion object{

        val singletonPartyBuilder : PartyBuilderI = newPartyBuilder()

        private fun newPartyBuilder(): PartyBuilderI {
            return PartyBuilder()
        }

        fun getPartyBuilder(): PartyBuilderI {
            return singletonPartyBuilder
        }
    }
}