package hexania.core.model.board

class Board (tiles : Array<Tile>) {

    val list_tiles : Array<Tile>

    init {
        this.list_tiles = tiles
    }
}