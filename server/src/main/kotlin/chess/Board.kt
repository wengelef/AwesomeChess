package chess

import java.util.*

data class Board(var fields: MutableMatrix<Field> = getDefaultBoard()) {

    init {
        reset()
    }

    fun reset() {
        fields = getDefaultBoard()
    }
}

private fun getDefaultBoard(): MutableMatrix<Field> = createMutableMatrix(8, 8) { x, y ->
    val team = when (y) {
        0, 1 -> Optional.of(Team.White)
        6, 7 -> Optional.of(Team.Black)
        else -> Optional.empty()
    }

    val piece = if (y == 0 || y == 7) {
        when (x) {
            0, 7 -> Optional.of(Rook)
            1, 6 -> Optional.of(Knight)
            2, 5 -> Optional.of(Bishop)
            3 -> if (team == Optional.of(Team.White)) {
                Optional.of(King)
            } else {
                Optional.of(Queen)
            }
            4 -> if (team == Optional.of(Team.White)) {
                Optional.of(Queen)
            } else {
                Optional.of(King)
            }
            else -> throw IllegalArgumentException("Field out of Bounds at $x, $y")
        }
    } else if (y == 1 || y == 6) {
        Optional.of(Pawn)
    } else {
        Optional.empty()
    }

    Field(team, piece)
}