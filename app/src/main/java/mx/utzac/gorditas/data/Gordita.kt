package mx.utzac.gorditas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gorditas")
data class Gordita(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val disponible: Boolean = true,
    val foto: String? = null
)
