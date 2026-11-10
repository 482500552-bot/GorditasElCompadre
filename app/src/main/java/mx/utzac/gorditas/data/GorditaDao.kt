package mx.utzac.gorditas.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface GorditaDao {
    @Query("SELECT * FROM gorditas ORDER BY nombre")
    fun todas(): Flow<List<Gordita>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(gordita: Gordita)

    @Update
    suspend fun actualizar(gordita: Gordita)

    @Delete
    suspend fun borrar(gordita: Gordita)
}
