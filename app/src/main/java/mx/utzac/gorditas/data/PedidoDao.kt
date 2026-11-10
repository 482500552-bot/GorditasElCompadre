package mx.utzac.gorditas.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
abstract class PedidoDao {
    @Transaction
    @Query("SELECT * FROM pedidos ORDER BY fecha DESC")
    abstract fun todos(): Flow<List<PedidoConItems>>

    @Insert
    abstract suspend fun insertarPedido(pedido: Pedido): Long

    @Insert
    abstract suspend fun insertarItems(items: List<ItemPedido>)

    @Query("UPDATE pedidos SET estado = :estado WHERE id = :id")
    abstract suspend fun cambiarEstado(id: Int, estado: String)

    @Query("SELECT * FROM pedidos WHERE sincronizado = 0")
    abstract suspend fun pendientesDeSincronizar(): List<Pedido>

    @Transaction
    open suspend fun crearPedido(pedido: Pedido, items: List<ItemPedido>): Long {
        val id = insertarPedido(pedido)
        insertarItems(items.map { it.copy(pedidoId = id.toInt()) })
        return id
    }
}
