package chess.model

import chess.model.Piece
import chess.model.Team
import java.util.*

data class Field(val owner: Optional<out Team>, val piece: Optional<out Piece>)