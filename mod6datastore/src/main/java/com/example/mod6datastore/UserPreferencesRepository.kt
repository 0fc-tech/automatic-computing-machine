package com.example.mod6datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesRepository(private val context: Context) {
    //Paramètre d'extension "dataStore" sur le contexte
    //Me permet de récupérer l'instance de dataStore
    // sur une instance Context
    private val Context.dataStore by preferencesDataStore(
        name = "user_preferences")

    suspend fun saveAdresse1(adresse: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_ADRESSE1] = adresse
        }
    }
    suspend fun saveAdresse2(adresse: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_ADRESSE2] = adresse
        }
    }
    suspend fun saveCodeEntreprise(code: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_CODE_ENTREPRISE] = code
        }
    }
    suspend fun saveCarteReduction(carteReduction: String) {
        val carteReductionInt = if(carteReduction.equals("")){
            0
        }else{
            carteReduction.toIntOrNull() ?: 0
        }
        context.dataStore.edit { preferences ->
            preferences[KEY_CARTE_REDUCTION] = carteReductionInt
        }
    }
    // Lire la couleur primaire
    val adressse1: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[KEY_ADRESSE1]
        }
    val adressse2: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[KEY_ADRESSE2]
        }
    val codeEntreprise: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[KEY_CODE_ENTREPRISE]
        }
    val carteReduction: Flow<String> = context.dataStore.data
        .map { preferences ->
            if(preferences[KEY_CARTE_REDUCTION] == 0)
                ""
            else preferences[KEY_CARTE_REDUCTION].toString()
        }


    companion object {
        private val KEY_ADRESSE1 = stringPreferencesKey("adresse_1")
        private val KEY_ADRESSE2 = stringPreferencesKey("adresse_2")
        private val KEY_CODE_ENTREPRISE = stringPreferencesKey("code_entreprise")
        private val KEY_CARTE_REDUCTION = intPreferencesKey("id_carte_reduction")
    }

}