package domain.preferences.usecases.imp

import domain.preferences.PreferenceRepository
import domain.preferences.usecases.RetrievePreferenceUseCase

class RetrievePreferenceUseCaesImp(private val preferenceRepository: PreferenceRepository) : RetrievePreferenceUseCase {
    override suspend fun execute(key: String): String? {
        return preferenceRepository.retrievePreference(key)
    }
}
