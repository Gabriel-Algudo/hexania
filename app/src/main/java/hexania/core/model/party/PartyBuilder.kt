package hexania.core.model.party

import hexania.core.model.board.Board
import hexania.core.model.character.Champion
import hexania.core.model.player.PlayerBuilderI

class PartyBuilder private constructor(

    private val players : MutableList<PlayerBuilderI> = mutableListOf<PlayerBuilderI>(),
    private val board: Board? = null

): PartyBuilderI {
    override fun reset() : PartyBuilderI{
        return PartyBuilder()
    }

    override fun addPlayer(playerBuilder: PlayerBuilderI): PartyBuilderI {
        val playerList = this.players
        playerList.add(playerBuilder)

        return PartyBuilder(playerList)
    }

    override fun setName(namelist: MutableList<String>): PartyBuilderI {
        TODO("Not yet implemented")
    }

    override fun setChampions(championList: MutableList<Champion>): PartyBuilderI {
        TODO("Not yet implemented")
    }

    override fun setArme(): PartyBuilderI {
        TODO("Not yet implemented")
    }

    override fun setRelique(): PartyBuilderI {
        TODO("Not yet implemented")
    }

    override fun setCompagnon(): PartyBuilderI {
        TODO("Not yet implemented")
    }

    override fun setArmure(): PartyBuilderI {
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
        fun newPartyBuilder(): PartyBuilderI{
            return PartyBuilder()
        }
    }
}