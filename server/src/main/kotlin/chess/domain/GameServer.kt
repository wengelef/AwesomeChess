package chess.domain

import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.WebSocketSession

interface GameServer {
    suspend fun memberJoin(member: String, socket: WebSocketSession)
    suspend fun memberRenamed(member: String, to: String)
    suspend fun memberLeft(member: String, socket: WebSocketSession)
    suspend fun who(sender: String)
    suspend fun sendTo(recipient: String, sender: String, message: String)
    suspend fun message(sender: String, message: String)
    suspend fun broadcast(message: String)
    suspend fun broadcast(sender: String, message: String)
    suspend fun List<WebSocketSession>.send(frame: Frame)
}