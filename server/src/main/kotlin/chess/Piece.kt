package chess


enum class Direction { Forward, Backward, Left, Right, Diagonally }

data class Move(val directions: Map<Direction, Int>)

sealed class Piece(val moves: List<Move>)


object King : Piece(listOf(
        Move(mapOf(
                Direction.Forward to 1
        )),
        Move(mapOf(
                Direction.Backward to 1
        )),
        Move(mapOf(
                Direction.Left to 1
        )),
        Move(mapOf(
                Direction.Right to 1
        )),
        Move(mapOf(
                Direction.Diagonally to 1
        ))
))

object Queen : Piece(listOf(
        Move(mapOf(
                Direction.Forward to 0
        )),
        Move(mapOf(
                Direction.Backward to 0
        )),
        Move(mapOf(
                Direction.Left to 0
        )),
        Move(mapOf(
                Direction.Right to 0
        )),
        Move(mapOf(
                Direction.Diagonally to 0
        ))
))

object Rook : Piece(listOf(
        Move(mapOf(
                Direction.Forward to 0
        )),
        Move(mapOf(
                Direction.Backward to 0
        )),
        Move(mapOf(
                Direction.Left to 0
        )),
        Move(mapOf(
                Direction.Right to 0
        ))
))

object Bishop : Piece(listOf(
        Move(mapOf(
                Direction.Diagonally to 0
        ))
))

object Knight : Piece(listOf(
        Move(mapOf(
                Direction.Forward to 2,
                Direction.Left to 1
        )),
        Move(mapOf(
                Direction.Forward to 2,
                Direction.Right to 1
        )),
        Move(mapOf(
                Direction.Backward to 2,
                Direction.Left to 1
        )),
        Move(mapOf(
                Direction.Backward to 2,
                Direction.Right to 1
        )),
        Move(mapOf(
                Direction.Left to 2,
                Direction.Forward to 1
        )),
        Move(mapOf(
                Direction.Left to 2,
                Direction.Backward to 1
        )),
        Move(mapOf(
                Direction.Right to 2,
                Direction.Forward to 1
        )),
        Move(mapOf(
                Direction.Right to 2,
                Direction.Backward to 1
        ))
))

object Pawn : Piece(listOf(Move(mapOf(Direction.Forward to 1))))