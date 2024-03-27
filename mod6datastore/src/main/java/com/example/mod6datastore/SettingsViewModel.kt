package com.example.mod6datastore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(val repo : UserPreferencesRepository) : ViewModel() {
    val adresse1StateFlow = repo.adressse1.stateIn(
        viewModelScope, SharingStarted.Eagerly, null)
    val adresse2StateFlow = repo.adressse2.stateIn(
        viewModelScope, SharingStarted.Eagerly, null)
    val codeEntrepriseStateFlow = repo.codeEntreprise.stateIn(
        viewModelScope, SharingStarted.Eagerly, null)
    val carteReductionStateFlow = repo.carteReduction.stateIn(
        viewModelScope, SharingStarted.Eagerly, null)

    fun saveAdresse1(adresse: String) {
        viewModelScope.launch {
            repo.saveAdresse1(adresse)
        }
    }
    fun saveAdresse2(adresse: String) {
        viewModelScope.launch {
            repo.saveAdresse2(adresse)
        }
    }
    fun saveCodeEntreprise(codeEntreprise: String) {
        viewModelScope.launch {
            repo.saveCodeEntreprise(codeEntreprise)
        }
    }
    fun saveCarteReduction(carteReduction: String) {
        viewModelScope.launch {
            repo.saveCarteReduction(carteReduction)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object :
            ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T { val application =
                checkNotNull(
                    extras[
                        ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY
                    ])
                return SettingsViewModel(
                    UserPreferencesRepository(application.applicationContext),
                ) as T
            }
        }
    }
}