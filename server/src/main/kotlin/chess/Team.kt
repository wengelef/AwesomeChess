package chess

sealed class Team {
    override fun toString(): String {
        return javaClass.simpleName
    }
}

object Black : Team()
object White : Team()