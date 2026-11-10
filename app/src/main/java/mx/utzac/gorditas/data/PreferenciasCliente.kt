package mx.utzac.gorditas.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "preferencias")

class PreferenciasCliente(private val context: Context) {
    private val claveNombre = stringPreferencesKey("nombre_cliente")
    private val claveEntrega = stringPreferencesKey("tipo_entrega")

    val nombre: Flow<String> =
        context.dataStore.data.map { it[claveNombre] ?: "" }

    val tipoEntrega: Flow<String> =
        context.dataStore.data.map { it[claveEntrega] ?: "DOMICILIO" }

    suspend fun guardarNombre(valor: String) {
        context.dataStore.edit { it[claveNombre] = valor }
    }

    suspend fun guardarTipoEntrega(valor: String) {
        context.dataStore.edit { it[claveEntrega] = valor }
    }
}
