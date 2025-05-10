package hexania.core.model.party

import hexania.core.model.board.Board
import hexania.core.model.character.Champion
import hexania.core.model.player.PlayerBuilderI

//A remplacer par un object PartyBuilder
class PartyBuilder private constructor(

    private val players : MutableList<PlayerBuilderI> = mutableListOf<PlayerBuilderI>(),
    private val board: Board? = null

): PartyBuilderI {
    override fun reset() : PartyBuilderI{
        return PartyBuilder()
    }

    override fun addAllPlayer(playerList: MutableList<PlayerBuilderI>) {
        this.players.addAll(playerList)
    }

    override fun setName(namelist: MutableList<String>) {
        TODO("Not yet implemented")
    }

    override fun setChampions(championList: MutableList<Champion>) {
        TODO("Not yet implemented")
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

    override fun build() :Party{
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        var string = "Party : ["
        players.forEach {
            string += "$it, "
        }
        return "$string ]"
    }

    companion object{

        val singletonPartyBuilder : PartyBuilderI = newPartyBuilder()

        private fun newPartyBuilder(): PartyBuilderI {
            return PartyBuilder()
        }

        fun getPartyBuilder(): PartyBuilderI{
            return singletonPartyBuilder
        }
    }
}