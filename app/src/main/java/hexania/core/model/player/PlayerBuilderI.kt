package hexania.core.model.player

interface PlayerBuilderI {

    fun reset() : PlayerBuilderI

    fun setName(nom : String) : PlayerBuilderI

    fun setArme() :PlayerBuilderI

    fun setRelique() :PlayerBuilderI

    fun setCompagnon() :PlayerBuilderI

    fun setArmure() :PlayerBuilderI

    fun toPlayer() : Player
}