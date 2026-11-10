package mx.utzac.gorditas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pedidos")
data class Pedido(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombreCliente: String,
    val tipoEntrega: String,
    val direccion: String? = null,
    val latitud: Double? = null,
    val longitud: Double? = null,
    val estado: String = "RECIBIDO",
    val total: Double,
    val fecha: Long = System.currentTimeMillis(),
    val sincronizado: Boolean = false
)
